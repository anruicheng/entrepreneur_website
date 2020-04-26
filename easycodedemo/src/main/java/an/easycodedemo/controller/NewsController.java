package an.easycodedemo.controller;

import an.easycodedemo.Utils.LayuiTypeJson;
import an.easycodedemo.entity.News;
import an.easycodedemo.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (News)表控制层
 *
 * @author makejava
 * @since 2020-03-13 20:42:15
 */
@RestController
public class NewsController {
    /**
     * 服务对象
     */
    @Resource
    private NewsService newsService;
    //用户进入某个具体的新闻页面，传入新闻的id，查到该新闻的信息
    @GetMapping("/toNewsDetail")
    public  News toNewsDetailPage(Model model,Integer newsId){
        News news = newsService.queryById(newsId);
        model.addAttribute("news",news);
        return news;
    }
    //管理员查看所有新闻，CRUD
    @GetMapping("ADMIN/allnews")
    public LayuiTypeJson<News> findAllNews(int page,int limit){
        List<News> newsList = newsService.queryAllByLimit((page-1)*limit,limit);
        LayuiTypeJson<News> layuiTypeJson = new LayuiTypeJson<>();
        layuiTypeJson.setCount(newsService.queryAll().size());
        layuiTypeJson.setData(newsList);
        return layuiTypeJson;
    }
    //根据新闻标题关键字查找新闻
    @GetMapping("ADMIN/news")
    public LayuiTypeJson<News> findNewsByTittle(String tittleKey) {
        List<News> list = newsService.searchNewsByTittle(tittleKey);
        LayuiTypeJson<News> layuiTypeJson=new LayuiTypeJson<>();
        layuiTypeJson.setData(list);
        layuiTypeJson.setCount(list.size());
        return layuiTypeJson;
    }

    @PostMapping("ADMIN/news")
    public void addNews(News news){
        String time=new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
        news.setNewsdata(time);
        newsService.insert(news);
    }

    @PutMapping("ADMIN/news")
    public void updateNews(News news){
        String time=new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
        news.setNewsdata(time);
        newsService.update(news);
    }
    @DeleteMapping("ADMIN/news")
    public void deleteNews(Integer newsid){
        newsService.deleteById(newsid);
    }
    //多选删除
    @DeleteMapping("ADMIN/CheckedNews")
    public void deleteCheckedNews(Integer[] newsid){
        for (int i = 0; i < newsid.length; i++) {
            newsService.deleteById(newsid[i]);
        }
    }



}
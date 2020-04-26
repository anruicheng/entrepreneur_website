package an.easycodedemo.service.impl;

import an.easycodedemo.entity.News;
import an.easycodedemo.dao.NewsDao;
import an.easycodedemo.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (News)表服务实现类
 *
 * @author makejava
 * @since 2020-03-13 20:42:14
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsDao newsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param newsid 主键
     * @return 实例对象
     */
    @Override
    public News queryById(Integer newsid) {
        return this.newsDao.queryById(newsid);
    }

    @Override
    public List<News> queryAll() {
        return newsDao.queryAll(new News());
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<News> queryAllByLimit(int offset, int limit) {
        return this.newsDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<News> searchNewsByTittle(String tittleKey) {
        return newsDao.searchNewsByTittle(tittleKey);
    }

    /**
     * 新增数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    @Override
    public News insert(News news) {
        this.newsDao.insert(news);
        return news;
    }

    /**
     * 修改数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    @Override
    public News update(News news) {
        this.newsDao.update(news);
        return this.queryById(news.getNewsid());
    }

    /**
     * 通过主键删除数据
     *
     * @param newsid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer newsid) {
        return this.newsDao.deleteById(newsid) > 0;
    }

}
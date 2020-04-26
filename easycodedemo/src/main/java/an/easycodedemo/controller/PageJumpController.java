package an.easycodedemo.controller;

import an.easycodedemo.entity.*;
import an.easycodedemo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author AnRuicheng
 * @date 2020/3/30 - 9:26
 */
@Controller
public class PageJumpController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private ActivityService activityService;
    @Autowired
    private MainpostService mainpostService;
    @Autowired
    private SubpostService subpostService;
    @Autowired
    private PostMessageService postMessageService;
    @Autowired
    private CompetitionService competitionService;
   //管理员登录页
    @RequestMapping("/toBackendHome")
    public String toBackendHomePage(){
        return "ADMIN/BackendHomePage";
    }
    //进入新闻页
    @RequestMapping("/toNewsPage")
    public String toNewsPage(Model model){
        List<News> list = newsService.queryAll();
        model.addAttribute("allNews",list);
        return "USER/news/news";
    }
    //进入活动页
    @RequestMapping("/toActivityPage")
    public String toActivityPage(Model model){
        List<Activity> list = activityService.queryAll();
        model.addAttribute("allActivities",list);
        return "USER/activity/activity";
    }
    //进入比赛页
    @RequestMapping("/toCompetitionPage")
    public String toCompetitionPage(Model model){
        List<Competition> list = competitionService.queryAll();
        model.addAttribute("allCompetitions",list);
        return "USER/competition/competition";
    }
    //进入贴吧导航页
    @RequestMapping("/toPostindexPage")
    public String toPostindexPage(){
        return "USER/post/postIndex";
    }

    //进入贴吧的评论区
    @RequestMapping("/toMessagePage")
    public String toMessagePage(Model model){
        List<PostMessage> postMessageList = postMessageService.queryAll();
        model.addAttribute("messageList",postMessageList);
        return "USER/post/message";
    }
    //进入某个具体类型的贴吧首页，要把该类型的帖子都放到model中
    @RequestMapping("/toMainPostPage")
    public String toMainPostPage(Model model, Integer type, HttpServletRequest httpServletRequest){
        httpServletRequest.getSession().setAttribute("type",type);
        List<Mainpost> mainpostList=mainpostService.queryByType(type);
        model.addAttribute("mainpostList",mainpostList);
        if (type==1) return "USER/post/mainPostEntreStory";
        else if(type==2) return "USER/post/mainPostProjectCommun";
        else return "USER/post/mainPostProjectShow";//type==3

    }
    //进入某一个帖子中，首先查出主贴，然后查出和主贴相关的从贴
    @RequestMapping("/toSubPost")
    public String toSubPost(int mainpostid,Model model){
        Mainpost mainpost = mainpostService.queryById(mainpostid);
        model.addAttribute("firstfloor",mainpost);
        List<Subpost> subpostList = subpostService.querryByMainpostId(mainpostid);
        model.addAttribute("subpostList",subpostList);
        return "USER/post/subPost";
    }
}

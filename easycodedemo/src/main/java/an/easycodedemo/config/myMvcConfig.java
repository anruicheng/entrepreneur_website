package an.easycodedemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author AnRuicheng
 * @date 2020/3/14 - 8:43
 */
@Configuration
public class myMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("LOG/LoginPage");
        registry.addViewController("/LoginPage.html").setViewName("LOG/LoginPage");
        registry.addViewController("/register.html").setViewName("LOG/register");
        registry.addViewController("newsDetail.html").setViewName("USER/news/newsDetail");
        registry.addViewController("activityDetail.html").setViewName("USER/activity/activityDetail");
        registry.addViewController("userUpdate.html").setViewName("USER/userUpdate");
        registry.addViewController("competitionDetail.html").setViewName("USER/competition/competitionDetail");
        registry.addViewController("/main.html").setViewName("ADMIN/main");
        registry.addViewController("/userList.html").setViewName("ADMIN/user/userList");
        registry.addViewController("/userAdd.html").setViewName("ADMIN/user/userAdd");
        registry.addViewController("/AdminUserUpdate.html").setViewName("ADMIN/user/userUpdate");
        registry.addViewController("/newsList.html").setViewName("ADMIN/news/newsList");
        registry.addViewController("/newsAdd.html").setViewName("ADMIN/news/newsAdd");
        registry.addViewController("/newsUpdate.html").setViewName("ADMIN/news/newsUpdate");
        registry.addViewController("/activityList.html").setViewName("ADMIN/activity/activityList");
        registry.addViewController("/activityAdd.html").setViewName("ADMIN/activity/activityAdd");
        registry.addViewController("/activityUpdate.html").setViewName("ADMIN/activity/activityUpdate");
        registry.addViewController("/competitionList.html").setViewName("ADMIN/competition/competitionList");
        registry.addViewController("/competitionAdd.html").setViewName("ADMIN/competition/competitionAdd");
        registry.addViewController("/competitionUpdate.html").setViewName("ADMIN/competition/competitionUpdate");
        registry.addViewController("mainPostList.html").setViewName("ADMIN/post/mainPostList");
        registry.addViewController("subPostList.html").setViewName("ADMIN/post/subPostList");
        registry.addViewController("postMessageList.html").setViewName("ADMIN/post/postMessageList");
        registry.addViewController("/attendRecord.html").setViewName("ADMIN/competition/attendRecord");

    }
}

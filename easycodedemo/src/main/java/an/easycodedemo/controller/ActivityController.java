package an.easycodedemo.controller;

import an.easycodedemo.Utils.LayuiTypeJson;
import an.easycodedemo.entity.Activity;
import an.easycodedemo.service.ActivityService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ActivityController {
    /**
     * 服务对象
     */
    @Resource
    private ActivityService activityService;
    //用户进入某个具体的活动，传入活动的id，查到该活动信息
    @RequestMapping("toActivityDetail")
    public Activity toActivityDetailPage(Model model, Integer activityId){
        Activity activity = activityService.queryById(activityId);
        model.addAttribute("activity",activity);
        return activity;
    }
    //ADMIN界面
    @GetMapping("ADMIN/activities")
    public LayuiTypeJson<Activity> findAllActivities(){
        List<Activity> list = activityService.queryAll();
        LayuiTypeJson<Activity> layuiTypeJson = new LayuiTypeJson<>();
        layuiTypeJson.setData(list);
        layuiTypeJson.setCount(list.size());
        return layuiTypeJson;
    }
    @GetMapping("ADMIN/activity")
    public LayuiTypeJson<Activity> searchActivityByTittle(String tittleKey){
        List<Activity> list = activityService.searchByTittle(tittleKey);
        LayuiTypeJson<Activity> layuiTypeJson = new LayuiTypeJson<>();
        layuiTypeJson.setData(list);
        layuiTypeJson.setCount(list.size());
        return layuiTypeJson;
    }
    //更改
    @PutMapping("ADMIN/activity")
    public void updateActivity(Activity activity){
        String time=new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
        activity.setActivitytime(time);
        String picurl="img/activity_img"+activity.getActivityid()%7+".jpg";
        activity.setActivityimagepath(picurl);
        activityService.update(activity);
    }
    //删除
    @DeleteMapping("ADMIN/activity")
    public void deleteActivity(Integer activityid){
        activityService.deleteById(activityid);
    }
    //增加
    @PostMapping("ADMIN/activity")
    public void addActivity(Activity activity){
        String time=new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
        activity.setActivitytime(time);
        String picurl="img/activity_img1.jpg";
        activity.setActivityimagepath(picurl);
        activityService.insert(activity);
    }

    @DeleteMapping("ADMIN/activities")
    public void deleteActivities(Integer[] activityid){
        for (int i = 0; i < activityid.length; i++) {
            activityService.deleteById(activityid[i]);
        }
    }

}
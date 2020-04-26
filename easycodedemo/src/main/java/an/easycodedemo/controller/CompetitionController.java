package an.easycodedemo.controller;

import an.easycodedemo.Utils.LayuiTypeJson;
import an.easycodedemo.entity.Activity;
import an.easycodedemo.entity.Competition;
import an.easycodedemo.service.CompetitionService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Competition)表控制层
 *
 * @author makejava
 * @since 2020-03-31 17:11:27
 */
@RestController
public class CompetitionController {
    /**
     * 服务对象
     */
    @Resource
    private CompetitionService competitionService;
    //用户进入某个具体的比赛页面，需传入比赛的id
    @RequestMapping("toCompetitionDetail")
    public  Competition toCompetitionDetailPage(Integer competitionId, Model model){
        Competition competition = competitionService.queryById(competitionId);
        model.addAttribute("competition",competition);
        return competition;
    }
    //管理员操作
    @GetMapping("ADMIN/competitions")
    public LayuiTypeJson<Competition> findAllActivities(int page,int limit){
        List<Competition> list = competitionService.queryAllByLimit((page-1)*limit,limit);
        LayuiTypeJson<Competition> layuiTypeJson = new LayuiTypeJson<>();
        layuiTypeJson.setData(list);
        layuiTypeJson.setCount(competitionService.queryAll().size());
        return layuiTypeJson;
    }
    //更改
    @PutMapping("ADMIN/competition")
    public void updateCompetition(Competition competition){
        String time=new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
        competition.setCompetitionTime(time);
        String picurl="img/activity_img"+competition.getCompetitionId()%7+".jpg";
        competition.setCompetitionImagepath(picurl);
        competitionService.update(competition);
    }
    //删除
    @DeleteMapping("ADMIN/competition")
    public void deleteCompetition(Integer competitionid){
        competitionService.deleteById(competitionid);
    }
    //增加
    @PostMapping("ADMIN/competition")
    public void addCompetition(Competition competition){
        String time=new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
        competition.setCompetitionTime(time);
        String picurl="img/activity_img1.jpg";
        competition.setCompetitionImagepath(picurl);
        competitionService.insert(competition);
    }

    @DeleteMapping("ADMIN/competitions")
    public void deleteCompetitions(Integer[] competitionid){
        for (int i = 0; i < competitionid.length; i++) {
            competitionService.deleteById(competitionid[i]);
        }
    }

}
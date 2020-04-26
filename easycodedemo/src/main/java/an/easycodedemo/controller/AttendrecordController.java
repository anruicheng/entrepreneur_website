package an.easycodedemo.controller;

import an.easycodedemo.Utils.LayuiTypeJson;
import an.easycodedemo.entity.Activity;
import an.easycodedemo.entity.Attendrecord;
import an.easycodedemo.entity.User;
import an.easycodedemo.service.AttendrecordService;
import an.easycodedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Attendrecord)表控制层
 *
 * @author makejava
 * @since 2020-04-01 16:50:48
 */
@RestController
public class AttendrecordController {
    /**
     * 服务对象
     */
    @Resource
    private AttendrecordService attendrecordService;
    @Autowired
    private UserService userService;
    //用户参赛
    @PostMapping("/Attendrecord")
    public Attendrecord addAttendrecords(String username,Attendrecord attendrecord){
        Integer userid = userService.queryByName(username).getUserid();
        attendrecord.setAttendrecorduserid(userid);
        String time=new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
        attendrecord.setAttendrecordtime(time);
        Attendrecord insert = attendrecordService.insert(attendrecord);
        return insert;
    }


    @GetMapping("ADMIN/Attendrecords")
    public LayuiTypeJson<Attendrecord> findAllAttendrecord(){
        List<Attendrecord> list = attendrecordService.queryAll();
        LayuiTypeJson<Attendrecord> layuiTypeJson = new LayuiTypeJson<>();
        layuiTypeJson.setData(list);
        layuiTypeJson.setCount(list.size());
        return layuiTypeJson;
    }

    @GetMapping("ADMIN/Attendrecord")
    public LayuiTypeJson<Attendrecord> searchByComId(int comId){
        List<Attendrecord> list = attendrecordService.searchByComId(comId);
        LayuiTypeJson<Attendrecord> layuiTypeJson = new LayuiTypeJson<>();
        layuiTypeJson.setData(list);
        layuiTypeJson.setCount(list.size());
        return layuiTypeJson;
    }
    //更改
    @PutMapping("ADMIN/Attendrecord")
    public void forbidAttend(Integer attendrecordid){
        Attendrecord attendrecord = attendrecordService.queryById(attendrecordid);
        attendrecord.setIsforbidden(1);
        attendrecordService.update(attendrecord);
    }
    //删除
    @DeleteMapping("ADMIN/Attendrecord")
    public void deleteAttendrecord(Integer id){
        attendrecordService.deleteById(id);
    }


}
package an.easycodedemo.controller;

import an.easycodedemo.Utils.LayuiTypeJson;
import an.easycodedemo.entity.Subpost;
import an.easycodedemo.service.SubpostService;
import an.easycodedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * (Subpost)表控制层
 *
 * @author makejava
 * @since 2020-03-30 09:28:30
 */
@RestController
public class SubpostController {
    /**
     * 服务对象
     */
    @Resource
    private SubpostService subpostService;
    @Autowired
    private UserService userService;
    //用户发布跟帖
    @PostMapping("USER/SubPost")
    public Subpost addSubPost(Subpost subpost){
        Integer userid = userService.queryByName(subpost.getSubpostUsername()).getUserid();
        subpost.setSubpostUserid(userid);
        String time=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()).toString();
        subpost.setSubpostTime(time);
        Integer floor = subpostService.getFloor(subpost.getSubpostMainid());
        subpost.setSubpostFloor(floor+2);
        Subpost insert = subpostService.insert(subpost);
        return insert;
    }
    //管理员查询所有跟帖
    @GetMapping("ADMIN/allSubPost")
    public LayuiTypeJson<Subpost> findAllSubPost(int page,int limit){
        LayuiTypeJson<Subpost> layuiTypeJson = new LayuiTypeJson<>();
        List<Subpost> subpostList = subpostService.queryAllByLimit((page-1)*limit,limit);
        Collections.sort(subpostList, new Comparator<Subpost>() {
            @Override
            public int compare(Subpost o1, Subpost o2) {
                if (o1.getSubpostMainid()>o2.getSubpostMainid()){
                    return 1;
                }else if (o1.getSubpostMainid()<o2.getSubpostMainid()){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        layuiTypeJson.setData(subpostList);
        layuiTypeJson.setCount(subpostService.querryAll().size());//所有数据的数量
        return layuiTypeJson;
    }
    //管理员删帖
    @DeleteMapping("ADMIN/SubPost")
    public void deleteSubPost(Integer id){
        subpostService.deleteById(id);
    }

    @GetMapping("ADMIN/SubPost")
    public LayuiTypeJson<Subpost> findSubPostByMainPostId(Integer mainPostId) {
        LayuiTypeJson<Subpost> layuiTypeJson = new LayuiTypeJson<>();
        List<Subpost> list = subpostService.querryByMainpostId(mainPostId);
        layuiTypeJson.setData(list);
        layuiTypeJson.setCount(list.size());
        return layuiTypeJson;
    }

    @PutMapping("SubPost")
    public void updateSubPost(Subpost subpost){
        String time=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()).toString();
        subpost.setSubpostTime(time);
        subpostService.update(subpost);
    }

    @DeleteMapping("ADMIN/SubPosts")
    public void deleteSubPost(Integer[] id){
        for (int i = 0; i < id.length; i++) {
            subpostService.deleteById(id[i]);
        }
    }


}
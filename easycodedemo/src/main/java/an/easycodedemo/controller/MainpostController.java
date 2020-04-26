package an.easycodedemo.controller;

import an.easycodedemo.Utils.LayuiTypeJson;
import an.easycodedemo.entity.Mainpost;
import an.easycodedemo.service.MainpostService;
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
 * (Mainpost)表控制层
 *
 * @author makejava
 * @since 2020-03-30 09:27:53
 */
@RestController
public class MainpostController {
    /**
     * 服务对象
     */
    @Resource
    private MainpostService mainpostService;
    @Autowired
    private UserService userService;
    //用户发表主贴
    @PostMapping("USER/MainPost")
    public Mainpost addMainpost(Mainpost mainpost){
        Integer userid = userService.queryByName(mainpost.getMainpostUsername()).getUserid();
        mainpost.setMainpostUserid(userid);
        String time=new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
        mainpost.setMainpostTime(time);
        Mainpost insert = mainpostService.insert(mainpost);
        return insert;
    }

    //管理员看所有的主贴，管理员不能更改帖或者发帖
    @GetMapping("ADMIN/allMainPost")
    public LayuiTypeJson<Mainpost> findAllMainpost(int page,int limit){
        LayuiTypeJson<Mainpost> layuiTypeJson=new LayuiTypeJson<>();
        List<Mainpost> mainpostList = mainpostService.queryAllByLimit((page-1)*limit,limit);
        Collections.sort(mainpostList, new Comparator<Mainpost>() {
            @Override
            public int compare(Mainpost o1, Mainpost o2) {
                if (o1.getMainpostType()<o2.getMainpostType()){
                    return -1;
                }else if(o1.getMainpostType()>o2.getMainpostType()){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        layuiTypeJson.setData(mainpostList);
        layuiTypeJson.setCount(mainpostService.queryAll().size());
        return layuiTypeJson;
    }
    //管理员对某个主题删除
    @DeleteMapping("ADMIN/MainPost")
    public void deleteMainpost(Integer id){
        mainpostService.deleteById(id);
    }

    @GetMapping("ADMIN/MainPost")
    public LayuiTypeJson<Mainpost> searchByTittle(String tittleKey) {
        LayuiTypeJson<Mainpost> layuiTypeJson = new LayuiTypeJson<>();
        List<Mainpost> list = mainpostService.searchByTittle(tittleKey);
        layuiTypeJson.setData(list);
        layuiTypeJson.setCount(list.size());
        return layuiTypeJson;
    }

    @PutMapping("MainPost")
    public void updateMainpost(Mainpost mainpost){
        String time=new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
        mainpost.setMainpostTime(time);
        mainpostService.update(mainpost);
    }

    @DeleteMapping("ADMIN/MainPosts")
    public void deleteMainposts(Integer[] id){
        for (int i = 0; i < id.length; i++) {
            mainpostService.deleteById(id[i]);
        }
    }

}
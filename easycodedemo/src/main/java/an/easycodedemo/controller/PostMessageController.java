package an.easycodedemo.controller;

import an.easycodedemo.Utils.LayuiTypeJson;
import an.easycodedemo.entity.PostMessage;
import an.easycodedemo.service.PostMessageService;
import an.easycodedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (PostMessage)表控制层
 *
 * @author makejava
 * @since 2020-03-30 09:28:12
 */
@RestController
public class PostMessageController {
    /**
     * 服务对象
     */
    @Resource
    private PostMessageService postMessageService;
    @Autowired
    private UserService userService;
    //用户发表留言
    @PostMapping("USER/PostMessage")
    public void addMessage(PostMessage postMessage){
        Integer userid = userService.queryByName(postMessage.getMessageUsername()).getUserid();
        postMessage.setMessageUserid(userid);
        String time=new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
        postMessage.setMessageTime(time);
        postMessageService.insert(postMessage);
    }
    //管理员查看留言，管理员不能发布或更改留言
    @GetMapping("ADMIN/allPostMessage")
    public LayuiTypeJson<PostMessage> findAllMessage(){
        LayuiTypeJson<PostMessage> layuiTypeJson=new LayuiTypeJson<>();
        List<PostMessage> postMessageList = postMessageService.queryAll();
        layuiTypeJson.setData(postMessageList);
        layuiTypeJson.setCount(postMessageList.size());
        return layuiTypeJson;
    }
    //删除留言
    @DeleteMapping("ADMIN/PostMessage")
    public void deleteMessage(Integer Messageid){
        postMessageService.deleteById(Messageid);
    }

    @GetMapping("ADMIN/PostMessage")
    public LayuiTypeJson<PostMessage> searchByContent(String key) {
        LayuiTypeJson<PostMessage> layuiTypeJson=new LayuiTypeJson<>();
        List<PostMessage> list = postMessageService.searchByContent(key);
        layuiTypeJson.setData(list);
        layuiTypeJson.setCount(list.size());
        return layuiTypeJson;
    }

    @PutMapping("ADMIN/PostMessage")
    public void updateMessage(PostMessage postMessage){
        String time=new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
        postMessage.setMessageTime(time);
        postMessageService.update(postMessage);
    }

}
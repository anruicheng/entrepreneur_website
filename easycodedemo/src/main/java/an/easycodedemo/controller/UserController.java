package an.easycodedemo.controller;

import an.easycodedemo.Utils.LayuiTypeJson;
import an.easycodedemo.entity.User;
import an.easycodedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-03-15 22:23:15
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    //用户跳到个人信息页面，修改个人数据
    @GetMapping("/toUserUpdate")
    public User toUserUpdate(String username){
        return userService.queryByName(username);
    }
    //更改个人信息，用户管理员都可以
    @PutMapping(value = {"ADMIN/user","/user"})
    public void updateUser(User user) {
        user.setRole("USER");
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        User userUpdate = userService.update(user);
    }
    //管理员添加USER，用户注册
    @PostMapping(value = {"ADMIN/user","/user"})
    public User addUser(@NotNull User user) {
        user.setRole("USER");
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        User insert = userService.insert(user);
        return insert;
    }
    //ADMIN
    @GetMapping("ADMIN/users")
    public LayuiTypeJson<User> findAllUsers(Model model) {
        List<User> users= userService.queryAll();
        LayuiTypeJson<User> layuiTypeJson=new LayuiTypeJson<>();
        layuiTypeJson.setCount(users.size());
        layuiTypeJson.setData(users);
        return layuiTypeJson;
    }
    //ADMIN搜索用户
    @GetMapping("ADMIN/user")
    public LayuiTypeJson<User> findUserByName(@NotNull String username) {
        List<User> users= userService.searchUserByName(username);
        LayuiTypeJson<User> layuiTypeJson=new LayuiTypeJson<>();
        layuiTypeJson.setCount(users.size());
        layuiTypeJson.setData(users);
        return layuiTypeJson;
    }

    @DeleteMapping("ADMIN/user")
    public void deleteUser(@NotNull Integer userId) {
        userService.deleteById(userId);
    }
    //批量删除
    @DeleteMapping("ADMIN/users")
    public void deleteUsers(@NotNull Integer[] userIds){
        for (int i = 0; i < userIds.length; i++) {
            userService.deleteById(userIds[i]);
        }
    }
}
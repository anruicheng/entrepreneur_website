package an.easycodedemo.service.impl;

import an.easycodedemo.entity.User;
import an.easycodedemo.dao.UserDao;
import an.easycodedemo.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2020-03-15 22:23:15
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer userid) {
        return this.userDao.queryById(userid);
    }

    @Override
    public User queryByName(String username) {
        return userDao.queryByName(username);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<User> queryAll() {
        return userDao.queryAll(new User());
    }
    @Override
    public List<User> searchUserByName(String username) {
        return userDao.searchUserByName(username);
    }
    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getUserid());
    }

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userid) {
        return this.userDao.deleteById(userid) > 0;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.queryByName(username);

        List<SimpleGrantedAuthority> list=new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),list);
        return userDetails;
    }
}
package an.easycodedemo.service.impl;

import an.easycodedemo.dao.ActivityDao;
import an.easycodedemo.entity.Activity;
import an.easycodedemo.service.ActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Activity)表服务实现类
 *
 * @author makejava
 * @since 2020-03-15 14:26:23
 */
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {
    @Resource
    private ActivityDao activityDao;

    /**
     * 通过ID查询单条数据
     *
     * @param activityid 主键
     * @return 实例对象
     */
    @Override
    public Activity queryById(Integer activityid) {
        return this.activityDao.queryById(activityid);
    }

    @Override
    public List<Activity> queryAll() {
        return activityDao.queryAll(new Activity());
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Activity> queryAllByLimit(int offset, int limit) {
        return this.activityDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Activity> searchByTittle(String tittleKey) {
        return activityDao.searchActivityByTittle(tittleKey);
    }

    /**
     * 新增数据
     *
     * @param activity 实例对象
     * @return 实例对象
     */
    @Override
    public Activity insert(Activity activity) {
        this.activityDao.insert(activity);
        return activity;
    }

    /**
     * 修改数据
     *
     * @param activity 实例对象
     * @return 实例对象
     */
    @Override
    public Activity update(Activity activity) {
        this.activityDao.update(activity);
        return this.queryById(activity.getActivityid());
    }

    /**
     * 通过主键删除数据
     *
     * @param activityid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer activityid) {
        return this.activityDao.deleteById(activityid) > 0;
    }
}
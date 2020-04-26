package an.easycodedemo.service;

import an.easycodedemo.entity.Activity;

import java.util.List;

/**
 * (Activity)表服务接口
 *
 * @author makejava
 * @since 2020-03-15 14:26:23
 */
public interface ActivityService {

    /**
     * 通过ID查询单条数据
     *
     * @param activityid 主键
     * @return 实例对象
     */
    Activity queryById(Integer activityid);

    List<Activity> queryAll();
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Activity> queryAllByLimit(int offset, int limit);
    List<Activity> searchByTittle(String tittleKey);
    /**
     * 新增数据
     *
     * @param activity 实例对象
     * @return 实例对象
     */
    Activity insert(Activity activity);

    /**
     * 修改数据
     *
     * @param activity 实例对象
     * @return 实例对象
     */
    Activity update(Activity activity);

    /**
     * 通过主键删除数据
     *
     * @param activityid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer activityid);

}
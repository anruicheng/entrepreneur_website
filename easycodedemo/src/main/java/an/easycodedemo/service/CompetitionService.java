package an.easycodedemo.service;

import an.easycodedemo.entity.Competition;
import java.util.List;

/**
 * (Competition)表服务接口
 *
 * @author makejava
 * @since 2020-03-31 17:11:27
 */
public interface CompetitionService {

    /**
     * 通过ID查询单条数据
     *
     * @param competitionId 主键
     * @return 实例对象
     */
    Competition queryById(Integer competitionId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Competition> queryAllByLimit(int offset, int limit);
    List<Competition> queryAll();
    /**
     * 新增数据
     *
     * @param competition 实例对象
     * @return 实例对象
     */
    Competition insert(Competition competition);

    /**
     * 修改数据
     *
     * @param competition 实例对象
     * @return 实例对象
     */
    Competition update(Competition competition);

    /**
     * 通过主键删除数据
     *
     * @param competitionId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer competitionId);

}
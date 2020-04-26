package an.easycodedemo.service;

import an.easycodedemo.entity.Subpost;
import java.util.List;

/**
 * (Subpost)表服务接口
 *
 * @author makejava
 * @since 2020-03-30 09:28:30
 */
public interface SubpostService {

    /**
     * 通过ID查询单条数据
     *
     * @param subpostId 主键
     * @return 实例对象
     */
    Subpost queryById(Integer subpostId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Subpost> queryAllByLimit(int offset, int limit);
    List<Subpost> querryAll();
    List<Subpost> querryByMainpostId(Integer MainpostId);
    Integer getFloor(Integer MainId);
    /**
     * 新增数据
     *
     * @param subpost 实例对象
     * @return 实例对象
     */
    Subpost insert(Subpost subpost);

    /**
     * 修改数据
     *
     * @param subpost 实例对象
     * @return 实例对象
     */
    Subpost update(Subpost subpost);

    /**
     * 通过主键删除数据
     *
     * @param subpostId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer subpostId);

}
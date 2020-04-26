package an.easycodedemo.dao;

import an.easycodedemo.entity.Subpost;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Subpost)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-30 09:28:30
 */
public interface SubpostDao {

    /**
     * 通过ID查询单条数据
     *
     * @param subpostId 主键
     * @return 实例对象
     */
    Subpost queryById(Integer subpostId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Subpost> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
    /**
     * 通过实体作为筛选条件查询
     *
     * @param subpost 实例对象
     * @return 对象列表
     */
    List<Subpost> queryAll(Subpost subpost);

    /**
     * 新增数据
     *
     * @param subpost 实例对象
     * @return 影响行数
     */
    int insert(Subpost subpost);

    /**
     * 修改数据
     *
     * @param subpost 实例对象
     * @return 影响行数
     */
    int update(Subpost subpost);

    /**
     * 通过主键删除数据
     *
     * @param subpostId 主键
     * @return 影响行数
     */
    int deleteById(Integer subpostId);
    int getFloor(Integer id);

}
package an.easycodedemo.dao;

import an.easycodedemo.entity.Mainpost;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Mainpost)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-30 09:27:52
 */
public interface MainpostDao {

    /**
     * 通过ID查询单条数据
     *
     * @param mainpostId 主键
     * @return 实例对象
     */
    Mainpost queryById(Integer mainpostId);
    List<Mainpost> queryByType(Integer type);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Mainpost> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<Mainpost> searchByTittle(String tittleKey);
    /**
     * 通过实体作为筛选条件查询
     *
     * @param mainpost 实例对象
     * @return 对象列表
     */
    List<Mainpost> queryAll(Mainpost mainpost);

    /**
     * 新增数据
     *
     * @param mainpost 实例对象
     * @return 影响行数
     */
    int insert(Mainpost mainpost);

    /**
     * 修改数据
     *
     * @param mainpost 实例对象
     * @return 影响行数
     */
    int update(Mainpost mainpost);

    /**
     * 通过主键删除数据
     *
     * @param mainpostId 主键
     * @return 影响行数
     */
    int deleteById(Integer mainpostId);

}
package an.easycodedemo.service;

import an.easycodedemo.entity.Mainpost;
import java.util.List;

/**
 * (Mainpost)表服务接口
 *
 * @author makejava
 * @since 2020-03-30 09:27:53
 */
public interface MainpostService {

    /**
     * 通过ID查询单条数据
     *
     * @param mainpostId 主键
     * @return 实例对象
     */
    Mainpost queryById(Integer mainpostId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Mainpost> queryAllByLimit(int offset, int limit);
    List<Mainpost> queryByType(int type);
    List<Mainpost> queryAll();
    List<Mainpost> searchByTittle(String tittleKey);
    /**
     * 新增数据
     *
     * @param mainpost 实例对象
     * @return 实例对象
     */
    Mainpost insert(Mainpost mainpost);

    /**
     * 修改数据
     *
     * @param mainpost 实例对象
     * @return 实例对象
     */
    Mainpost update(Mainpost mainpost);

    /**
     * 通过主键删除数据
     *
     * @param mainpostId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer mainpostId);

}
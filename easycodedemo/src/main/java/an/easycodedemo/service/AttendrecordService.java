package an.easycodedemo.service;

import an.easycodedemo.entity.Attendrecord;
import java.util.List;

/**
 * (Attendrecord)表服务接口
 *
 * @author makejava
 * @since 2020-04-01 16:50:47
 */
public interface AttendrecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param attendrecordid 主键
     * @return 实例对象
     */
    Attendrecord queryById(Integer attendrecordid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Attendrecord> queryAllByLimit(int offset, int limit);
    List<Attendrecord> queryAll();
    List<Attendrecord> searchByComId(int id);
    /**
     * 新增数据
     *
     * @param attendrecord 实例对象
     * @return 实例对象
     */
    Attendrecord insert(Attendrecord attendrecord);

    /**
     * 修改数据
     *
     * @param attendrecord 实例对象
     * @return 实例对象
     */
    Attendrecord update(Attendrecord attendrecord);

    /**
     * 通过主键删除数据
     *
     * @param attendrecordid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer attendrecordid);

}
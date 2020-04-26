package an.easycodedemo.service.impl;

import an.easycodedemo.entity.Attendrecord;
import an.easycodedemo.dao.AttendrecordDao;
import an.easycodedemo.service.AttendrecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Attendrecord)表服务实现类
 *
 * @author makejava
 * @since 2020-04-01 16:50:47
 */
@Service("attendrecordService")
public class AttendrecordServiceImpl implements AttendrecordService {
    @Resource
    private AttendrecordDao attendrecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param attendrecordid 主键
     * @return 实例对象
     */
    @Override
    public Attendrecord queryById(Integer attendrecordid) {
        return this.attendrecordDao.queryById(attendrecordid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Attendrecord> queryAllByLimit(int offset, int limit) {
        return this.attendrecordDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Attendrecord> queryAll() {
        return attendrecordDao.queryAll(new Attendrecord());
    }

    @Override
    public List<Attendrecord> searchByComId(int compId) {
        Attendrecord attendrecord = new Attendrecord();
        attendrecord.setAttendrecordcompid(compId);
        List<Attendrecord> list = attendrecordDao.queryAll(attendrecord);
        return list;
    }

    /**
     * 新增数据
     *
     * @param attendrecord 实例对象
     * @return 实例对象
     */
    @Override
    public Attendrecord insert(Attendrecord attendrecord) {
        this.attendrecordDao.insert(attendrecord);
        return attendrecord;
    }

    /**
     * 修改数据
     *
     * @param attendrecord 实例对象
     * @return 实例对象
     */
    @Override
    public Attendrecord update(Attendrecord attendrecord) {
        this.attendrecordDao.update(attendrecord);
        return this.queryById(attendrecord.getAttendrecordid());
    }

    /**
     * 通过主键删除数据
     *
     * @param attendrecordid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer attendrecordid) {
        return this.attendrecordDao.deleteById(attendrecordid) > 0;
    }
}
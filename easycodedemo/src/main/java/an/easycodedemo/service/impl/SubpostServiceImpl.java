package an.easycodedemo.service.impl;

import an.easycodedemo.entity.Subpost;
import an.easycodedemo.dao.SubpostDao;
import an.easycodedemo.service.SubpostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Subpost)表服务实现类
 *
 * @author makejava
 * @since 2020-03-30 09:28:30
 */
@Service("subpostService")
public class SubpostServiceImpl implements SubpostService {
    @Resource
    private SubpostDao subpostDao;

    /**
     * 通过ID查询单条数据
     *
     * @param subpostId 主键
     * @return 实例对象
     */
    @Override
    public Subpost queryById(Integer subpostId) {
        return this.subpostDao.queryById(subpostId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Subpost> queryAllByLimit(int offset, int limit) {
        return this.subpostDao.queryAllByLimit(offset, limit);
    }
    @Override
    public List<Subpost> querryAll() {
        return subpostDao.queryAll(new Subpost());
    }

    @Override
    public List<Subpost> querryByMainpostId(Integer MainpostId) {
        Subpost subpost=new Subpost();
        subpost.setSubpostMainid(MainpostId);
        return subpostDao.queryAll(subpost);
    }

    @Override
    public Integer getFloor(Integer MainId) {
        return subpostDao.getFloor(MainId);
    }
    /**
     * 新增数据
     *
     * @param subpost 实例对象
     * @return 实例对象
     */
    @Override
    public Subpost insert(Subpost subpost) {
        this.subpostDao.insert(subpost);
        return subpost;
    }

    /**
     * 修改数据
     *
     * @param subpost 实例对象
     * @return 实例对象
     */
    @Override
    public Subpost update(Subpost subpost) {
        this.subpostDao.update(subpost);
        return this.queryById(subpost.getSubpostId());
    }

    /**
     * 通过主键删除数据
     *
     * @param subpostId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer subpostId) {
        return this.subpostDao.deleteById(subpostId) > 0;
    }
}
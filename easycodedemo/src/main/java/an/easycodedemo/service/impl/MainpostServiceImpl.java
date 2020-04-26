package an.easycodedemo.service.impl;

import an.easycodedemo.entity.Mainpost;
import an.easycodedemo.dao.MainpostDao;
import an.easycodedemo.service.MainpostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Mainpost)表服务实现类
 *
 * @author makejava
 * @since 2020-03-30 09:27:53
 */
@Service("mainpostService")
public class MainpostServiceImpl implements MainpostService {
    @Resource
    private MainpostDao mainpostDao;

    /**
     * 通过ID查询单条数据
     *
     * @param mainpostId 主键
     * @return 实例对象
     */
    @Override
    public Mainpost queryById(Integer mainpostId) {
        return this.mainpostDao.queryById(mainpostId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Mainpost> queryAllByLimit(int offset, int limit) {
        return this.mainpostDao.queryAllByLimit(offset, limit);
    }
    @Override
    public List<Mainpost> queryByType(int type) {
        return mainpostDao.queryByType(type);
    }

    @Override
    public List<Mainpost> queryAll() {
        return mainpostDao.queryAll(new Mainpost());
    }

    @Override
    public List<Mainpost> searchByTittle(String tittleKey) {
        return mainpostDao.searchByTittle(tittleKey);
    }

    /**
     * 新增数据
     *
     * @param mainpost 实例对象
     * @return 实例对象
     */
    @Override
    public Mainpost insert(Mainpost mainpost) {
        this.mainpostDao.insert(mainpost);
        return mainpost;
    }

    /**
     * 修改数据
     *
     * @param mainpost 实例对象
     * @return 实例对象
     */
    @Override
    public Mainpost update(Mainpost mainpost) {
        this.mainpostDao.update(mainpost);
        return this.queryById(mainpost.getMainpostId());
    }

    /**
     * 通过主键删除数据
     *
     * @param mainpostId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer mainpostId) {
        return this.mainpostDao.deleteById(mainpostId) > 0;
    }
}
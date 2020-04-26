package an.easycodedemo.service.impl;

import an.easycodedemo.entity.Competition;
import an.easycodedemo.dao.CompetitionDao;
import an.easycodedemo.service.CompetitionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Competition)表服务实现类
 *
 * @author makejava
 * @since 2020-03-31 17:11:27
 */
@Service("competitionService")
public class CompetitionServiceImpl implements CompetitionService {
    @Resource
    private CompetitionDao competitionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param competitionId 主键
     * @return 实例对象
     */
    @Override
    public Competition queryById(Integer competitionId) {
        return this.competitionDao.queryById(competitionId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Competition> queryAllByLimit(int offset, int limit) {
        return this.competitionDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Competition> queryAll() {
        return competitionDao.queryAll(new Competition());
    }

    /**
     * 新增数据
     *
     * @param competition 实例对象
     * @return 实例对象
     */
    @Override
    public Competition insert(Competition competition) {
        this.competitionDao.insert(competition);
        return competition;
    }

    /**
     * 修改数据
     *
     * @param competition 实例对象
     * @return 实例对象
     */
    @Override
    public Competition update(Competition competition) {
        this.competitionDao.update(competition);
        return this.queryById(competition.getCompetitionId());
    }

    /**
     * 通过主键删除数据
     *
     * @param competitionId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer competitionId) {
        return this.competitionDao.deleteById(competitionId) > 0;
    }
}
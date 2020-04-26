package an.easycodedemo.service;

import an.easycodedemo.entity.News;
import java.util.List;

/**
 * (News)表服务接口
 *
 * @author makejava
 * @since 2020-03-13 20:42:14
 */
public interface NewsService {

    /**
     * 通过ID查询单条数据
     *
     * @param newsid 主键
     * @return 实例对象
     */
    News queryById(Integer newsid);

    List<News> queryAll();
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<News> queryAllByLimit(int offset, int limit);
    List<News> searchNewsByTittle(String tittleKey);
    /**
     * 新增数据
     *
     * @param news 实例对象
     * @return 实例对象
     */


    News insert(News news);

    /**
     * 修改数据
     *
     * @param news 实例对象
     * @return 实例对象
     */
    News update(News news);

    /**
     * 通过主键删除数据
     *
     * @param newsid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer newsid);

}
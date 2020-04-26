package an.easycodedemo.service;

import an.easycodedemo.entity.PostMessage;
import java.util.List;

/**
 * (PostMessage)表服务接口
 *
 * @author makejava
 * @since 2020-03-30 09:28:12
 */
public interface PostMessageService {

    /**
     * 通过ID查询单条数据
     *
     * @param messageId 主键
     * @return 实例对象
     */
    PostMessage queryById(Integer messageId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PostMessage> queryAllByLimit(int offset, int limit);
    List<PostMessage> queryAll();
    List<PostMessage> searchByContent(String key);
    /**
     * 新增数据
     *
     * @param postMessage 实例对象
     * @return 实例对象
     */
    PostMessage insert(PostMessage postMessage);

    /**
     * 修改数据
     *
     * @param postMessage 实例对象
     * @return 实例对象
     */
    PostMessage update(PostMessage postMessage);

    /**
     * 通过主键删除数据
     *
     * @param messageId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer messageId);

}
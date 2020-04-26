package an.easycodedemo.service.impl;

import an.easycodedemo.entity.PostMessage;
import an.easycodedemo.dao.PostMessageDao;
import an.easycodedemo.service.PostMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PostMessage)表服务实现类
 *
 * @author makejava
 * @since 2020-03-30 09:28:12
 */
@Service("postMessageService")
public class PostMessageServiceImpl implements PostMessageService {
    @Resource
    private PostMessageDao postMessageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param messageId 主键
     * @return 实例对象
     */
    @Override
    public PostMessage queryById(Integer messageId) {
        return this.postMessageDao.queryById(messageId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<PostMessage> queryAllByLimit(int offset, int limit) {
        return this.postMessageDao.queryAllByLimit(offset, limit);
    }
    @Override
    public List<PostMessage> queryAll() {
        return postMessageDao.queryAll(new PostMessage());
    }

    @Override
    public List<PostMessage> searchByContent(String key) {
        return postMessageDao.searchByContent(key);
    }

    /**
     * 新增数据
     *
     * @param postMessage 实例对象
     * @return 实例对象
     */
    @Override
    public PostMessage insert(PostMessage postMessage) {
        this.postMessageDao.insert(postMessage);
        return postMessage;
    }

    /**
     * 修改数据
     *
     * @param postMessage 实例对象
     * @return 实例对象
     */
    @Override
    public PostMessage update(PostMessage postMessage) {
        this.postMessageDao.update(postMessage);
        return this.queryById(postMessage.getMessageId());
    }

    /**
     * 通过主键删除数据
     *
     * @param messageId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer messageId) {
        return this.postMessageDao.deleteById(messageId) > 0;
    }
}
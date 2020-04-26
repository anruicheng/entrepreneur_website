package an.easycodedemo.entity;

import java.io.Serializable;

/**
 * (PostMessage)实体类
 *
 * @author makejava
 * @since 2020-03-30 09:28:10
 */
public class PostMessage implements Serializable {
    private static final long serialVersionUID = 724634005554556810L;
    
    private Integer messageId;
    
    private Object messageContent;
    
    private String messageTime;
    
    private Integer messageUserid;
    
    private String messageUsername;


    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Object getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(Object messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    public Integer getMessageUserid() {
        return messageUserid;
    }

    public void setMessageUserid(Integer messageUserid) {
        this.messageUserid = messageUserid;
    }

    public String getMessageUsername() {
        return messageUsername;
    }

    public void setMessageUsername(String messageUsername) {
        this.messageUsername = messageUsername;
    }

}
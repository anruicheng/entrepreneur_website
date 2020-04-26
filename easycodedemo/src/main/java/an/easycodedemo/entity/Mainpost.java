package an.easycodedemo.entity;

import java.io.Serializable;

/**
 * (Mainpost)实体类
 *
 * @author makejava
 * @since 2020-03-30 09:27:51
 */
public class Mainpost implements Serializable {
    private static final long serialVersionUID = -97725922363558835L;
    
    private Integer mainpostId;
    
    private String mainpostTittle;
    
    private String mainpostContent;
    
    private String mainpostDesc;
    
    private String mainpostTime;
    
    private Integer mainpostUserid;
    
    private String mainpostUsername;
    
    private Integer mainpostType;


    public Integer getMainpostId() {
        return mainpostId;
    }

    public void setMainpostId(Integer mainpostId) {
        this.mainpostId = mainpostId;
    }

    public String getMainpostTittle() {
        return mainpostTittle;
    }

    public void setMainpostTittle(String mainpostTittle) {
        this.mainpostTittle = mainpostTittle;
    }

    public String getMainpostContent() {
        return mainpostContent;
    }

    public void setMainpostContent(String mainpostContent) {
        this.mainpostContent = mainpostContent;
    }

    public String getMainpostDesc() {
        return mainpostDesc;
    }

    public void setMainpostDesc(String mainpostDesc) {
        this.mainpostDesc = mainpostDesc;
    }

    public String getMainpostTime() {
        return mainpostTime;
    }

    public void setMainpostTime(String mainpostTime) {
        this.mainpostTime = mainpostTime;
    }

    public Integer getMainpostUserid() {
        return mainpostUserid;
    }

    public void setMainpostUserid(Integer mainpostUserid) {
        this.mainpostUserid = mainpostUserid;
    }

    public String getMainpostUsername() {
        return mainpostUsername;
    }

    public void setMainpostUsername(String mainpostUsername) {
        this.mainpostUsername = mainpostUsername;
    }

    public Integer getMainpostType() {
        return mainpostType;
    }

    public void setMainpostType(Integer mainpostType) {
        this.mainpostType = mainpostType;
    }

}
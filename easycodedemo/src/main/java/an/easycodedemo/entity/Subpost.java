package an.easycodedemo.entity;

import java.io.Serializable;

/**
 * (Subpost)实体类
 *
 * @author makejava
 * @since 2020-03-30 09:28:28
 */
public class Subpost implements Serializable {
    private static final long serialVersionUID = -31473547272742412L;
    
    private Integer subpostId;
    
    private String subpostContent;
    
    private String subpostTime;
    
    private Integer subpostMainid;
    
    private Integer subpostUserid;
    
    private String subpostUsername;
    
    private Integer subpostFloor;


    public Integer getSubpostId() {
        return subpostId;
    }

    public void setSubpostId(Integer subpostId) {
        this.subpostId = subpostId;
    }

    public String getSubpostContent() {
        return subpostContent;
    }

    public void setSubpostContent(String subpostContent) {
        this.subpostContent = subpostContent;
    }

    public String getSubpostTime() {
        return subpostTime;
    }

    public void setSubpostTime(String subpostTime) {
        this.subpostTime = subpostTime;
    }

    public Integer getSubpostMainid() {
        return subpostMainid;
    }

    public void setSubpostMainid(Integer subpostMainid) {
        this.subpostMainid = subpostMainid;
    }

    public Integer getSubpostUserid() {
        return subpostUserid;
    }

    public void setSubpostUserid(Integer subpostUserid) {
        this.subpostUserid = subpostUserid;
    }

    public String getSubpostUsername() {
        return subpostUsername;
    }

    public void setSubpostUsername(String subpostUsername) {
        this.subpostUsername = subpostUsername;
    }

    public Integer getSubpostFloor() {
        return subpostFloor;
    }

    public void setSubpostFloor(Integer subpostFloor) {
        this.subpostFloor = subpostFloor;
    }

}
package an.easycodedemo.entity;

import java.io.Serializable;

/**
 * (Attendrecord)实体类
 *
 * @author makejava
 * @since 2020-04-01 16:56:14
 */
public class Attendrecord implements Serializable {
    private static final long serialVersionUID = 861432620186446021L;
    
    private Integer attendrecordid;
    
    private Integer attendrecorduserid;
    
    private Integer attendrecordcompid;
    
    private Integer isforbidden;
    
    private String attendrecordtime;


    public Integer getAttendrecordid() {
        return attendrecordid;
    }

    public void setAttendrecordid(Integer attendrecordid) {
        this.attendrecordid = attendrecordid;
    }

    public Integer getAttendrecorduserid() {
        return attendrecorduserid;
    }

    public void setAttendrecorduserid(Integer attendrecorduserid) {
        this.attendrecorduserid = attendrecorduserid;
    }

    public Integer getAttendrecordcompid() {
        return attendrecordcompid;
    }

    public void setAttendrecordcompid(Integer attendrecordcompid) {
        this.attendrecordcompid = attendrecordcompid;
    }

    public Integer getIsforbidden() {
        return isforbidden;
    }

    public void setIsforbidden(Integer isforbidden) {
        this.isforbidden = isforbidden;
    }

    public String getAttendrecordtime() {
        return attendrecordtime;
    }

    public void setAttendrecordtime(String attendrecordtime) {
        this.attendrecordtime = attendrecordtime;
    }

    @Override
    public String toString() {
        return "Attendrecord{" +
                "attendrecordid=" + attendrecordid +
                ", attendrecorduserid=" + attendrecorduserid +
                ", attendrecordcompid=" + attendrecordcompid +
                ", isforbidden=" + isforbidden +
                ", attendrecordtime='" + attendrecordtime + '\'' +
                '}';
    }
}
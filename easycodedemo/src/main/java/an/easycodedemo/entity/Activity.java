package an.easycodedemo.entity;

import java.io.Serializable;

/**
 * (Activity)实体类
 *
 * @author makejava
 * @since 2020-03-17 09:18:01
 */
public class Activity implements Serializable {
    private static final long serialVersionUID = -15708860514155179L;
    
    private Integer activityid;
    
    private String activitytittle;
    
    private String activitydesc;
    
    private Object activitycontent;
    
    private String activityimagepath;
    
    private String activitytime;


    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public String getActivitytittle() {
        return activitytittle;
    }

    public void setActivitytittle(String activitytittle) {
        this.activitytittle = activitytittle;
    }

    public String getActivitydesc() {
        return activitydesc;
    }

    public void setActivitydesc(String activitydesc) {
        this.activitydesc = activitydesc;
    }

    public Object getActivitycontent() {
        return activitycontent;
    }

    public void setActivitycontent(Object activitycontent) {
        this.activitycontent = activitycontent;
    }

    public String getActivityimagepath() {
        return activityimagepath;
    }

    public void setActivityimagepath(String activityimagepath) {
        this.activityimagepath = activityimagepath;
    }

    public String getActivitytime() {
        return activitytime;
    }

    public void setActivitytime(String activitytime) {
        this.activitytime = activitytime;
    }

}
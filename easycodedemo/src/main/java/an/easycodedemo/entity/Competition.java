package an.easycodedemo.entity;

import java.io.Serializable;

/**
 * (Competition)实体类
 *
 * @author makejava
 * @since 2020-03-31 21:28:47
 */
public class Competition implements Serializable {
    private static final long serialVersionUID = 139116706760969411L;
    
    private Integer competitionId;
    
    private String competitionTittle;
    
    private String competitionDesc;
    
    private String competitionContent;
    
    private String competitionTime;
    
    private String competitionImagepath;


    public Integer getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Integer competitionId) {
        this.competitionId = competitionId;
    }

    public String getCompetitionTittle() {
        return competitionTittle;
    }

    public void setCompetitionTittle(String competitionTittle) {
        this.competitionTittle = competitionTittle;
    }

    public String getCompetitionDesc() {
        return competitionDesc;
    }

    public void setCompetitionDesc(String competitionDesc) {
        this.competitionDesc = competitionDesc;
    }

    public String getCompetitionContent() {
        return competitionContent;
    }

    public void setCompetitionContent(String competitionContent) {
        this.competitionContent = competitionContent;
    }

    public String getCompetitionTime() {
        return competitionTime;
    }

    public void setCompetitionTime(String competitionTime) {
        this.competitionTime = competitionTime;
    }

    public String getCompetitionImagepath() {
        return competitionImagepath;
    }

    public void setCompetitionImagepath(String competitionImagepath) {
        this.competitionImagepath = competitionImagepath;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "competitionId=" + competitionId +
                ", competitionTittle='" + competitionTittle + '\'' +
                ", competitionDesc='" + competitionDesc + '\'' +
                ", competitionContent='" + competitionContent + '\'' +
                ", competitionTime='" + competitionTime + '\'' +
                ", competitionImagepath='" + competitionImagepath + '\'' +
                '}';
    }
}
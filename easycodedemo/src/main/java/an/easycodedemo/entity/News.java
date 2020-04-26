package an.easycodedemo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (News)实体类
 *
 * @author makejava
 * @since 2020-03-13 20:42:12
 */

public class News implements Serializable {
    private static final long serialVersionUID = 635660103541112977L;
    
    private Integer newsid;
    
    private String newstittle;
    
    private String newscontent;
    
    private String newsdata;
    
    private String newsdesc;
    
    private Integer newsistop;
    
    private String newsimagepath;


    public Integer getNewsid() {
        return newsid;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    public String getNewstittle() {
        return newstittle;
    }

    public void setNewstittle(String newstittle) {
        this.newstittle = newstittle;
    }

    public String getNewscontent() {
        return newscontent;
    }

    public void setNewscontent(String newscontent) {
        this.newscontent = newscontent;
    }

    public String getNewsdata() {
        return newsdata;
    }

    public void setNewsdata(String newsdata) {
        this.newsdata = newsdata;
    }

    public String getNewsdesc() {
        return newsdesc;
    }

    public void setNewsdesc(String newsdesc) {
        this.newsdesc = newsdesc;
    }

    public Integer getNewsistop() {
        return newsistop;
    }

    public void setNewsistop(Integer newsistop) {
        this.newsistop = newsistop;
    }

    public String getNewsimagepath() {
        return newsimagepath;
    }

    public void setNewsimagepath(String newsimagepath) {
        this.newsimagepath = newsimagepath;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsid=" + newsid +
                ", newstittle='" + newstittle + '\'' +
                ", newscontent='" + newscontent + '\'' +
                ", newsdata=" + newsdata +
                ", newsdesc='" + newsdesc + '\'' +
                ", newsistop=" + newsistop +
                ", newsimagepath='" + newsimagepath + '\'' +
                '}';
    }
}
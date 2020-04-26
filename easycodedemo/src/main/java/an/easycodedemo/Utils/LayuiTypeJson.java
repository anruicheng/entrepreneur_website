package an.easycodedemo.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AnRuicheng
 * @date 2020/3/31 - 15:29
 */
public class LayuiTypeJson<T> {
    private int code=0;
    private String msg="";
    private int count;
    private List<T> data=new ArrayList<T>();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}

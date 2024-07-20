package cn.xll.employmentanalysis.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Result {

    @JsonIgnore
    private Map map;

    //消息编码
//    private Boolean result;
    private Boolean success;
    //消息体
    private Object data;

    //消息
    private String message;

    //消息常用编码
    public static Boolean OK = true;
    public static Boolean ERROR = false;
    public static Boolean FAIL = false;
    public static Boolean NOTFOUND = true;

    public static Result ok(String msg) {
        return new Result(OK, "", msg);
    }

    public static Result ok() {
        return new Result(OK, "", "");
    }

    public static Result ok(Object data) {
        return new Result(OK, data, "成功");
    }


    public static Result ok(Object data, String msg) {
        return new Result(OK, data, msg);
    }

    public static Result error() {
        return new Result(ERROR, "", "错误");
    }

    public static Result error(String msg) {
        return new Result(ERROR, "", msg);
    }

    public static Result exception(String e) {
        return new Result(ERROR, e, e);
    }

    public static Result fail() {
        return new Result(FAIL, "", "失败");
    }

    //构造的map
    @JsonIgnore
    public Map<Object, Object> resMap = new HashMap<>();


    public static Result init(Boolean code, String msg) {
        return new Result(code, msg);
    }

    //构造map返回
    public Result add(Object key, Object value) {
        resMap.put(key, value);
        return this;
    }

    public Result build() {
        data = resMap;
        return this;
    }

    public Result(Boolean result, Object data, String msg) {
        this.success = result;
        this.data = data;
        this.message = msg;
    }

    public Result(Object data, String msg) {
        this.data = data;
        this.message = msg;
    }

    public Result(Boolean code, String msg) {
        this.success = code;
        this.message = msg;
    }
}

package com.wzy.wzy_shop.util;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class R {
    private int code;
    private String msg;
    private Map<String, String> map;

    private R() {
        map = new HashMap<>();
    }

    private R(int code, String msg) {
        this.code = code;
        this.msg = msg;
        map = new HashMap<>();
    }

    public static R build() {
        return new R();
    }

    public static String success() {
        R r = new R(2000, "提交成功了");
        return JSONObject.toJSONString(r);
    }

    public static String fail() {
        R r = new R(5000, "提交失败了");
        return JSONObject.toJSONString(r);
    }

    public static String send(int code, String msg) {
        R r = new R(code, msg);
        return JSONObject.toJSONString(r);
    }

    public R add(String key, String value) {
        map.put(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public R setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public R setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "R{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", map=" + map +
                '}';
    }
}

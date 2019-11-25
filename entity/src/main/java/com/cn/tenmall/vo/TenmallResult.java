package com.cn.tenmall.vo;

import lombok.Data;

@Data
public class TenmallResult {

    /**
     * 响应状态码
     * 200 成功
     * 201 错误
     * 400 参数错误
     */
    private Integer status;

    //响应消息
    private String msg;

    //响应中的数据
    private Object data;

    public TenmallResult() {

    }

    public static TenmallResult build(Integer status, String msg, Object data) {
        return new TenmallResult(status, msg, data);
    }

    public static TenmallResult build(Integer status, String msg) {
        return new TenmallResult(status, msg, null);
    }

    public static TenmallResult ok(Object data) {
        return new TenmallResult(data);
    }

    public static TenmallResult ok() {
        return new TenmallResult(null);
    }

    public TenmallResult(Object data) {
        this.status = 1;
        this.msg = "ok";
        this.data = data;
    }

    public TenmallResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

}

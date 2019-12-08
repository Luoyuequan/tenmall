package com.cn.tenmall.vo;

import com.cn.tenmall.enumClass.MessageEnum;
import lombok.Data;

@Data
public class TenmallResult {

    /**
     * 1:失败
     * 0:成功
     */
    private Integer status;

    //响应消息
    private String msg;

    //响应中的数据
    private Object data;

    //错误调用
    public TenmallResult(Throwable e) {
        this.status = 1;
        this.msg = e.getMessage();

    }

    public TenmallResult() {

    }

    public static TenmallResult build(Integer status, String msg, Object data) {
        return new TenmallResult(status, msg, data);
    }

    public static TenmallResult build(Integer status, String msg) {
        return build(status, msg, null);
    }

    public static TenmallResult error(MessageEnum messageEnum) {
        return build(messageEnum.getCode(), messageEnum.getMessage());
    }

    /**
     * 业务成功 反馈提示语和数据
     *
     * @param messageEnum 消息枚举类
     * @param data        数据
     * @return view object
     */
    public static TenmallResult success(MessageEnum messageEnum, Object data) {
        return new TenmallResult(messageEnum.getCode(), messageEnum.getMessage(), data);
    }

    /**
     * 业务成功 反馈提示语且无数据
     *
     * @param messageEnum 消息枚举类
     * @return view object
     */
    public static TenmallResult success(MessageEnum messageEnum) {
        return success(messageEnum, null);
    }

    public static TenmallResult ok(Object data) {
        return new TenmallResult(data);
    }

    public static TenmallResult ok() {
        return ok(null);
    }

    private TenmallResult(Object data) {
        this.status = 0;
        this.msg = "ok";
        this.data = data;
    }

    private TenmallResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

}

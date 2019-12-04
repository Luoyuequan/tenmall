package com.cn.tenmall.enumClass;

public enum MessageEnum {
    ADD_ERROR(1, "新增失败"),
    UPDATE_ERROR(1, "修改失败"),
    FIND_ERROR(1, "查询失败"),
    DELETE_ERROR(1, "删除失败");

    //错误代码
    private Integer code;
    //错误描述
    private String message;

    private MessageEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.cn.tenmall.enumClass;

public enum MessageEnum {
    /**
     * 操作成功 提示语
     */
    ACTION_SUCCESS(0, "操作成功"),
    /**
     * 新增失败
     */
    ADD_ERROR(1, "新增失败"),
    /**
     * 新增成功
     */
    ADD_SUCCESS(0, "新增成功"),
    /**
     * 删除失败
     */
    DELETE_ERROR(1, "删除失败"),
    /**
     * 查询失败
     */
    FIND_ERROR(1, "查询失败"),
    /**
     * 登录错误
     */
    LOGIN_ERROR(1, "用户名或密码错误"),
    /**
     * 修改失败
     */
    UPDATE_ERROR(1, "修改失败"),
    /**
     * 接收的参数无效
     */
    VARIABLE_INVALID_ERROR(1, "参数无效,请检查后,重新尝试"),

    /**
     * 接收的参数数量不符合要求
     */
    VARIABLE_MISS_ERROR(1, "参数缺失,请检查后,重新尝试");

    /**
     * 错误代码
     */
    private Integer code;
    /**
     * 错误描述
     */
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

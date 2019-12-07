package com.cn.tenmall.entity;


import lombok.Data;

/**
 * 退货退款原因表
 *
 * @author 罗跃权
 */
@Data
public class WxTabReturnCauseEntity {

    private Integer id;
    private String cause;
    private Integer seq;
    private String status;
}

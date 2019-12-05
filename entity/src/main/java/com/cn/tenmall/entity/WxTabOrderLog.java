package com.cn.tenmall.entity;


import lombok.Data;

/**
 * 订单日志
 *
 * @author 罗跃权
 */
@Data
public class WxTabOrderLog {

    private Integer id;
    private String operater;
    private java.sql.Timestamp operaterTime;
    private Integer orderId;
    private String orderStatus;
    private String payStatus;
    private String consignStatus;
    private String remarks;
}

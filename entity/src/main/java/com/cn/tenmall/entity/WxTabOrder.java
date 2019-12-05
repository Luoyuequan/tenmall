package com.cn.tenmall.entity;

import lombok.Data;

/**
 * 订单主表
 *
 * @author luo
 */
@Data
public class WxTabOrder {

    private Integer id;
    private Integer totalNum;
    private Integer totalMoney;
    private Integer preMoney;
    private Integer postFee;
    private Integer payMoney;
    private String payType;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;
    private java.sql.Timestamp payTime;
    private java.sql.Timestamp consignTime;
    private java.sql.Timestamp endTime;
    private java.sql.Timestamp closeTime;
    private String shippingName;
    private String shippingCode;
    private String username;
    private String buyerMessage;
    private String buyerRate;
    private String receiverContact;
    private String receiverMobile;
    private String receiverAddress;
    private String sourceType;
    private Integer tansactionId;
    private String orderStatus;
    private String payStatus;
    private String consignStatus;
    private String isDelete;

}

package com.cn.tenmall.entity;

import lombok.Data;

/**
 * 订单主表
 *
 * @author luoyuequan
 */
@Data
public class WxTabOrderEntity {

    private Integer id;
    private Integer totalNum;
    private Integer totalMoney;
    private Integer preMoney;
    private Integer postFee;
    private Integer payMoney;
    private Integer payType;
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
    private Integer buyerRate;
    private String receiverContact;
    private String receiverMobile;
    private String receiverAddress;
    private Integer sourceType;
    private Integer tansactionId;
    private Integer orderStatus;
    private Integer payStatus;
    private Integer consignStatus;
    private Integer isDelete;
}

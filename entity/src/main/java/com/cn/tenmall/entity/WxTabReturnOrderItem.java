package com.cn.tenmall.entity;


import lombok.Data;

/**
 * 退货退款申请明细表
 *
 * @author 罗跃权
 */
@Data
public class WxTabReturnOrderItem {

    private String id;
    private String categoryId;
    private String spuId;
    private String skuId;
    private String orderId;
    private String orderItemId;
    private String returnOrderId;
    private String titile;
    private Integer price;
    private Integer num;
    private Integer money;
    private Integer payMoney;
    private String image;
    private Integer weight;
}

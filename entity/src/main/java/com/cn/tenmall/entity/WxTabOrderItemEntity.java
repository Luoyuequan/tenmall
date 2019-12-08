package com.cn.tenmall.entity;

import lombok.Data;

/**
 * 订单详细表
 *
 * @author 罗跃权
 */
@Data
public class WxTabOrderItemEntity {

    private Integer id;
    private Integer categoryId1;
    private Integer categoryId2;
    private Integer categoryId3;
    private Integer spuId;
    private Integer skuId;
    private Integer orderId;
    private String name;
    private Double price;
    private Integer num;
    private Double money;
    private Double payMoney;
    private String image;
    private Integer weight;
    private Integer postFee;
    private String isReturn;

}

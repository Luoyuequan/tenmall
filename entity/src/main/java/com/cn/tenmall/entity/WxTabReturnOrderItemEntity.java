package com.cn.tenmall.entity;

import lombok.Data;

/**
 * 退货退款申请明细表
 *
 * @author 罗跃权
 */
@Data
public class WxTabReturnOrderItemEntity {

  private Integer id;
  private Integer categoryId;
  private Integer spuId;
  private Integer skuId;
  private Integer orderId;
  private Integer orderItemId;
  private Integer returnOrderId;
  private String title;
  private Double price;
  private Integer num;
  private Double money;
  private Double payMoney;
  private String image;
  private Double weight;
}

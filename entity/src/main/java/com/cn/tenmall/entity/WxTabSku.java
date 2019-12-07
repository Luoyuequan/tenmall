package com.cn.tenmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxTabSku {
  private String id;
  private String sn;
  private String name;
  private long price;
  private long num;
  private long alertNum;
  private String image;
  private String images;
  private long weight;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private String spuId;
  private long categoryId;
  private String categoryName;
  private String brandName;
  private String spec;
  private long saleNum;
  private long commentNum;
  private String status;
}

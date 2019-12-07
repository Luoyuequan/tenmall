package com.cn.tenmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxTabSpu {
  private long id;
  private String sn;
  private String name;
  private String caption;
  private long brandId;
  private long category1Id;
  private long category2Id;
  private long category3Id;
  private long templateId;
  private long freightId;
  private String image;
  private String images;
  private String saleService;
  private String introduction;
  private String specItems;
  private String paraItems;
  private long saleNum;
  private long commentNum;
  private String isMarketable;
  private String isEnableSpec;
  private String isDelete;
  private String status;
}

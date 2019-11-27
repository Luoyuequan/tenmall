package com.cn.tenmall.entity;

import lombok.Data;

@Data
public class WxTabMenu {
  private Long id;
  private String name;
  private String icon;
  private String url;
  private String parentId;

  public WxTabMenu(){}
  public WxTabMenu(Long id, String name, String icon, String url, String parentId) {
    this.id = id;
    this.name = name;
    this.icon = icon;
    this.url = url;
    this.parentId = parentId;
  }

}

package com.cn.tenmall.entity;

import lombok.Data;

@Data
public class WxTabMenu {

  private String id;
  private String name;
  private String icon;
  private String url;
  private String parentId;
  public WxTabMenu(){}
  public WxTabMenu(String id, String name, String icon, String url, String parentId) {
    this.id = id;
    this.name = name;
    this.icon = icon;
    this.url = url;
    this.parentId = parentId;
  }

  @Override
  public String toString() {
    return "WxTabMenu{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", icon='" + icon + '\'' +
            ", url='" + url + '\'' +
            ", parentId='" + parentId + '\'' +
            '}';
  }
}

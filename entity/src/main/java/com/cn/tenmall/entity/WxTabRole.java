package com.cn.tenmall.entity;

import lombok.Data;

@Data
public class WxTabRole {

  private long id;
  private String roleName;

  public WxTabRole(){}
  public WxTabRole(long id, String roleName) {
    this.id = id;
    this.roleName = roleName;
  }
}

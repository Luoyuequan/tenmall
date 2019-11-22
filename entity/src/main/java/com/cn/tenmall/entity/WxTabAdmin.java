package com.cn.tenmall.entity;

import lombok.Data;

@Data
public class WxTabAdmin {
  private long id;
  private String loginName;
  private String password;
  private long status;
  public WxTabAdmin(){}

  public WxTabAdmin(long id, String loginName, String password, long status) {
    this.id = id;
    this.loginName = loginName;
    this.password = password;
    this.status = status;
  }

}

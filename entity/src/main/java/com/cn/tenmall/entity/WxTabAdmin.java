package com.cn.tenmall.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@Data
public class WxTabAdmin {
  public interface adminSim{}
  public interface adminDeta extends adminSim{}
  private long id;
  private String loginName;
  @JsonView(adminDeta.class)
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

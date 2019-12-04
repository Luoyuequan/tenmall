package com.cn.tenmall.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxTabAdmin {
  private long id;
  private String loginName;
  @JsonView(adminDeta.class)
  private String password;
  private long status;
  public interface adminSim{}
  public interface adminDeta extends adminSim{}
}

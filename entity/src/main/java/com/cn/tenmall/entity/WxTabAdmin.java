package com.cn.tenmall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class WxTabAdmin {
  @TableId(type = IdType.AUTO)
  private long id;
  @TableField(value = "login_name",exist = true)
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

  @Override
  public String toString() {
    return "WxTabAdmin{" +
            "id=" + id +
            ", loginName='" + loginName + '\'' +
            ", password='" + password + '\'' +
            ", status=" + status +
            '}';
  }
}

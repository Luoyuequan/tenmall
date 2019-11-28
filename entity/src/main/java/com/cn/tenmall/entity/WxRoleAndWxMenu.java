package com.cn.tenmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxRoleAndWxMenu {
  private long id;
  private long roleId;
  private long menuId;
}

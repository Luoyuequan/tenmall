package com.cn.tenmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxTabMenu {
  private Long id;
  private String name;
  private String icon;
  private String url;
  private String parentId;

}

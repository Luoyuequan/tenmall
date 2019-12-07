package com.cn.tenmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxTabAlbum {
  private long id;
  @NotNull
  private String title;
  @NotNull
  private String image;
  @NotNull
  private String imageItems;
}

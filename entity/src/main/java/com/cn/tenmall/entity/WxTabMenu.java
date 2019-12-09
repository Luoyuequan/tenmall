package com.cn.tenmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxTabMenu {
    private Long id;
    @NotNull
    private String name;
    private String icon;
    private String url;
    private String parentId;

}

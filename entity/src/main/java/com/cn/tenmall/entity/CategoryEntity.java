package com.cn.tenmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity {
    // 分类ID
    private Integer id;
    // 分类名称
    @NotNull
    private String name;
    // 商品数量
    private Integer goodsNum = 0;
    // 是否显示
    @NotNull
    private String isShow;
    // 是否导航
    @NotNull
    private String isMenu;
    // 排序
    private Integer seq;
    // 上级ID
    @NotNull
    private Integer parentId = 0;
    // 模板ID
    @NotNull
    private Integer templateId;
}

package com.cn.tenmall.entity;

import lombok.Data;

@Data
public class CategoryEntity {
    // 分类ID
    private Integer id;
    // 分类名称
    private String name;
    // 商品数量
    private Integer goodsNum;
    // 是否显示
    private String isShow;
    // 是否导航
    private String isMenu;
    // 排序
    private Integer seq;
    // 上级ID
    private Integer parentId;
    // 模板ID
    private Integer templateId;

}

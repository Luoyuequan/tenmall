package com.cn.tenmall.entity;

import lombok.Data;

import java.security.PrivateKey;

@Data
public class SepcEntity {

    private Integer id;
    //名称
    private String name;
    //规格选项
    private String options;
    //排序
    private Integer seq;
    //模板ID
    private Integer templateId;
}

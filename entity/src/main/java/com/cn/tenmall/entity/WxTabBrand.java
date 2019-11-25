package com.cn.tenmall.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class WxTabBrand implements Serializable {
    private Integer id;
    private String name;
    private String image;
    private String letter;
    private Integer seq;
}

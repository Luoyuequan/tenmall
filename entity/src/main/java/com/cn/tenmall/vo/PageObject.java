package com.cn.tenmall.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageObject<T> {
    //总记录数
    private Integer total;
    //查询结果
    private List<T> rows;

}

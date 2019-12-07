package com.cn.tenmall.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageObject<T> {
    //总记录数
    private Integer total;
    //查询结果
    private List<T> rows;

}

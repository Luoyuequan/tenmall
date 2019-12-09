package com.cn.tenmall.entity;


import lombok.Data;

import java.sql.Timestamp;

/**
 * 存储统计数据表
 *
 * @author 罗跃权
 */
@Data
public class WxTabCategoryReportEntity {

    private Integer categoryId1;
    private Integer categoryId2;
    private Integer categoryId3;
    private Timestamp countDate;
    private Integer num;
    private Double money;
}

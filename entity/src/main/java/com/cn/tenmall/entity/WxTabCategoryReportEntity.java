package com.cn.tenmall.entity;


import lombok.Data;

import java.util.Date;

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
    private Date countDate;
    private Integer num;
    private Integer money;
}

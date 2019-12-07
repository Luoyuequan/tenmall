package com.cn.tenmall.entity;


import lombok.Data;

/**
 * 订单设置表
 *
 * @author 罗跃权
 */
@Data
public class WxTabOrderConfigEntity {

    private Integer id;
    private Integer orderTimeout;
    private Integer seckillTimeout;
    private Integer takeTimeout;
    private Integer serviceTimeout;
    private Integer commentTimeout;
}

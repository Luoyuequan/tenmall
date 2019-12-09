package com.cn.tenmall.entity;

import lombok.Data;

/**
 * 退货退款申请表
 *
 * @author 罗跃权
 */
@Data
public class WxTabReturnOrderEntity {

    private Integer id;
    private Integer orderId;
    private java.sql.Timestamp applyTime;
    private Integer userId;
    private String userAccount;
    private String linkman;
    private String linkmanMobile;
    private Integer type;
    private Double returnMoney;
    private Integer isReturnFreight;
    private Integer status;
    private java.sql.Timestamp disposeTime;
    private Integer returnCause;
    private String evidence;
    private String description;
    private String remark;
    private Integer adminId;
}

package com.cn.tenmall.entity;

import lombok.Data;

/**
 * 退货退款申请表
 *
 * @author 罗跃权
 */
@Data
public class WxTabReturnOrder {

    private String id;
    private String orderId;
    private String applyTime;
    private String userId;
    private String userAccount;
    private String linkman;
    private String linkmanMobile;
    private String type;
    private Integer returnMoney;
    private String isReturnFreight;
    private String status;
    private java.sql.Timestamp disposeTime;
    private Integer returnCause;
    private String evidence;
    private String description;
    private String remark;
    private Integer adminId;
}

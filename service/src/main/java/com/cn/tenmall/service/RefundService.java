package com.cn.tenmall.service;

import com.cn.tenmall.vo.TenmallResult;

import java.util.Map;

/**
 * 退款或退货 业务
 *
 * @author luoyuequan
 * @time 2019/11/22 16:55
 */
public interface RefundService {
    /**
     * 查询 退货退款申请表 分页
     *
     * @param data 分页参数(page,size)
     * @return 退货退款申请表
     */
    TenmallResult findAll(Map data);

    /**
     * 退款 退货 审批业务
     *
     * @param data 退款退货申请id,审批类型status
     * @return 操作结果信息
     */
    TenmallResult approval(Map data);

    /**
     * 退货退款原因 信息
     *
     * @param id 原因表id
     * @return 原因信息
     */
    TenmallResult findCause(Integer id);
}

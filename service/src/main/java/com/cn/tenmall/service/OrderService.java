package com.cn.tenmall.service;

import com.cn.tenmall.vo.TenmallResult;

import java.util.Map;

/**
 * @author luoyuequan
 * @time 2019/11/22 16:50
 */
public interface OrderService {
    /**
     * 订单列表及明细
     *
     * @param data 请求参数map
     * @return 订单信息列表
     */
    TenmallResult listInfo(Map data);

    /**
     * 批量发货查询
     *
     * @param idArray 订单id组
     * @return 订单列表
     */
    TenmallResult batchList(String[] idArray);

    /**
     * 批量发货提交
     *
     * @param data 请求参数map
     * @return 批量发货提交后信息
     */
    TenmallResult batchSendSubmit(Map data);

}

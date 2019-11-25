package com.cn.tenmall.service.impl;

import com.cn.tenmall.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author luoyuequan
 * @version 1.00
 * @ClassName OrderServiceImpl
 * @time 2019/11/22 16:56
 */
@Service
public class OrderServiceImpl implements OrderService {

    /**
     * 订单列表及明细
     *
     * @param data 请求参数map
     * @return 订单信息列表
     */
    @Override
    public List listInfo(Map data) {
        return null;
    }

    /**
     * 批量发货查询
     *
     * @param idArray 订单id组
     * @return 订单列表
     */
    @Override
    public List batchList(String[] idArray) {
        return null;
    }

    /**
     * 批量发货提交
     *
     * @param data 请求参数map
     * @return 批量发货提交后信息
     */
    @Override
    public Map batchSendSubmit(Map data) {
        return null;
    }
}

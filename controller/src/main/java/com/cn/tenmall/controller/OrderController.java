package com.cn.tenmall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单管理
 *
 * @author luoyuequan
 * @version 1.00
 * @ClassName OrderController
 * @time 2019/11/21 12:14
 */
@RestController
@RequestMapping(value = "/order/*", method = {RequestMethod.POST})
public class OrderController {
    /**
     * 订单列表及明细接口
     *
     * @return
     */
    @RequestMapping(value = "list")
    public String list() {
        return "test";
    }

    /**
     * 批量发货查询接口
     *
     * @return
     */
    @RequestMapping(value = "batchlist")
    public String batchList() {
        return "test";
    }

    /**
     * 批量发货提交接口
     *
     * @return
     */
    @RequestMapping(value = "batchSendSubmit")
    public String batchSendSubmit() {
        return "test";
    }
}

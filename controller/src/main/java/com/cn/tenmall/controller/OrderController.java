package com.cn.tenmall.controller;

import com.cn.tenmall.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 订单管理
 *
 * @author luoyuequan
 * @version 1.00
 * @ClassName OrderController
 * @time 2019/11/21 12:14
 */
@CrossOrigin
@RestController
@RequestMapping(value = "order", method = RequestMethod.POST)
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 订单列表及明细接口
     *
     * @return 订单列表
     */
    @RequestMapping(value = "findAll")
    public List list(@RequestBody Map data) {
        if (Objects.equals(data.get("page"), null) || Objects.equals(data.get("size"), null)) {
            Map<String, Object> vo = new HashMap<>(16);
            vo.put("code", 1);
            vo.put("message", "page或size参数缺失,请检查后,重新尝试!");
            return List.of(vo);
        }
        return orderService.listInfo(data);
    }

    /**
     * 批量发货查询接口
     *
     * @return 发货的订单列表
     */
    @RequestMapping(value = "batchFindAll")
    public List batchList(@RequestParam(name = "ids") String ids) {
        String[] idArray = ids.split(",");
        return orderService.batchList(idArray);
    }

    /**
     * 批量发货提交接口
     *
     * @return 批量发货提交后信息
     */
    @RequestMapping(value = "batchSendSubmit")
    public Map batchSendSubmit(@RequestBody Map data) {
        if (data.size() < 3) {
            Map<String, Object> vo = new HashMap<>(16);
            vo.put("code", 1);
            vo.put("message", "orderId、shippingName、shippingCode参数缺失,请检查后,重新尝试!");
            return vo;
        }
        return orderService.batchSendSubmit(data);
    }
}

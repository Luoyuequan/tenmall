package com.cn.tenmall.controller;

import com.cn.tenmall.enumClass.MessageEnum;
import com.cn.tenmall.service.OrderService;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

/**
 * 订单管理
 *
 * @author luoyuequan
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
    public TenmallResult list(@RequestBody Map data) {
        String pageVariableName = "page";
        String sizeVariableName = "size";
        if (Objects.equals(data.get(pageVariableName), null) || Objects.equals(data.get(sizeVariableName), null)) {
            return TenmallResult.error(MessageEnum.VARIABLE_MISS_ERROR);
        }
        return orderService.listInfo(data);
    }

    /**
     * 批量发货查询接口
     *
     * @return 发货的订单列表
     */
    @RequestMapping(value = "batchFindAll")
    public TenmallResult batchList(@RequestBody Map data) {
        if (data.isEmpty()) {
            return TenmallResult.error(MessageEnum.VARIABLE_MISS_ERROR);
        }
        String[] idArray = ((String) data.get("ids")).split(",");
        if (idArray.length == 0) {
            return TenmallResult.error(MessageEnum.VARIABLE_INVALID_ERROR);
        }
        return orderService.batchList(idArray);
    }

    /**
     * 批量发货提交接口
     *
     * @return 批量发货提交后信息
     */
    @RequestMapping(value = "batchSendSubmit")
    public TenmallResult batchSendSubmit(@RequestBody Map data) {
        int varLength = 3;
        if (data.isEmpty() || data.size() < varLength) {
            return TenmallResult.error(MessageEnum.VARIABLE_MISS_ERROR);
        }
        return orderService.batchSendSubmit(data);
    }
}

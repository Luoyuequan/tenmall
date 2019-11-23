package com.cn.tenmall.controller;

import com.cn.tenmall.service.OrderService;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
//@CrossOrigin
@RestController
@RequestMapping(value = "order", method = RequestMethod.POST)
public class OrderController {
    @Resource
    OrderService orderService;

    /**
     * 订单列表及明细接口
     *
     * @return
     */
    @RequestMapping(value = "list")
    public List list(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        if (Objects.equals(map.get("page"), null) || Objects.equals(map.get("size"), null)) {
            return null;
        }
        return orderService.listInfo();
    }

    /**
     * 批量发货查询接口
     *
     * @return
     */
    @RequestMapping(value = "batchlist", method = RequestMethod.GET)
    public TenmallResult batchList() {
        return null;
    }

    /**
     * 批量发货提交接口
     *
     * @return
     */
    @RequestMapping(value = "batchSendSubmit")
    public TenmallResult batchSendSubmit() {
        return null;
    }
}

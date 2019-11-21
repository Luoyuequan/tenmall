package com.cn.tenmall.controller.order;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luoyuequan
 * @version 1.00
 * @ClassName OrderController
 * @time 2019/11/21 12:14
 */
@RestController
@RequestMapping("/order/*")
public class OrderController {
    @RequestMapping(value = "getMsg", method = {RequestMethod.GET})
    public String getMsg() {
        return "test";
    }
}

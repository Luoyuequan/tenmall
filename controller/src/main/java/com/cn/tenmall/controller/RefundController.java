package com.cn.tenmall.controller;

import com.cn.tenmall.vo.TenmallResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 退款流程接口
 *
 * @author luoyuequan
 * @version 1.00
 * @ClassName RefundController
 * @time 2019/11/22 15:34
 */
@RestController
@RequestMapping(value = "/refund/*", method = RequestMethod.POST)
public class RefundController {
    /**
     * 退款审批列表接口
     *
     * @return
     */
    @RequestMapping(value = "list")
    public TenmallResult list() {
        return null;
    }

    /**
     * 退款审批接口
     *
     * @return
     */
    @RequestMapping(value = "approval")
    public TenmallResult approval() {
        return null;
    }

    /**
     * 退款原因
     *
     * @return
     */
    @RequestMapping(value = "casue")
    public TenmallResult casue() {
        return null;
    }
}

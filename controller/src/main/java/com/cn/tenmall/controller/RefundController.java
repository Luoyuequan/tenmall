package com.cn.tenmall.controller;

import com.cn.tenmall.enumClass.MessageEnum;
import com.cn.tenmall.service.RefundService;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

/**
 * 退款退货流程接口
 *
 * @author luoyuequan
 * @time 2019/11/22 15:34
 */
@RestController
@RequestMapping(value = "refund", method = RequestMethod.POST)
public class RefundController {
    private final RefundService refundService;

    public RefundController(RefundService refundService) {
        this.refundService = refundService;
    }

    /**
     * 退款审批列表接口
     *
     * @return 退货退款申请表
     */
    @RequestMapping(value = "findAll")
    public TenmallResult list(@RequestBody Map data) {
        String pageVariableName = "page";
        String sizeVariableName = "size";
        if (Objects.equals(data.get(pageVariableName), null) || Objects.equals(data.get(sizeVariableName), null)) {
            return TenmallResult.error(MessageEnum.VARIABLE_MISS_ERROR);
        }
        return refundService.findAll(data);
    }

    /**
     * 退款审批接口
     *
     * @return 操作结果
     */
    @RequestMapping(value = "approval")
    public TenmallResult approval(@RequestBody Map data) {
        int varLength = 2;
        if (data.size() < varLength) {
            return TenmallResult.error(MessageEnum.VARIABLE_MISS_ERROR);
        }
        return refundService.approval(data);
    }

    /**
     * 退款原因
     *
     * @return 查询退款原因
     */
    @RequestMapping(value = {"cause", "casue"})
    public TenmallResult cause(@RequestBody Map data) {
        int varLength = 1;
        if (data.size() < varLength) {
            return TenmallResult.error(MessageEnum.VARIABLE_MISS_ERROR);
        } else {
            return refundService.findCause((Integer) data.get("id"));
        }
    }
}

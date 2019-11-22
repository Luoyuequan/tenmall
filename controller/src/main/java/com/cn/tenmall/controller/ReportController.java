package com.cn.tenmall.controller;

import com.cn.tenmall.vo.TenmallResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 统计分析
 * 类别统计接口
 *
 * @author luoyuequan
 * @version 1.00
 * @ClassName ReportController
 * @time 2019/11/22 15:36
 */
@RestController
@RequestMapping(value = "/report/*")
public class ReportController {
    /**
     * 日期统计一级分类接口
     *
     * @return
     */
    @RequestMapping(value = "cagegory1Level", method = RequestMethod.POST)
    public TenmallResult category1Level() {
        return null;
    }
}

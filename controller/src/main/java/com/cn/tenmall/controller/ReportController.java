package com.cn.tenmall.controller;

import com.cn.tenmall.entity.WxTabCategoryReportEntity;
import com.cn.tenmall.enumClass.MessageEnum;
import com.cn.tenmall.service.ReportService;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 统计分析
 * 类别统计接口
 *
 * @author luoyuequan
 * @time 2019/11/22 15:36
 */
@RestController
@RequestMapping(value = "report")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    /**
     * 日期统计一级分类接口
     *
     * @return 统计数据
     */
    @RequestMapping(value = {"category1Level", "cagegory1Level"}, method = RequestMethod.POST)
    public TenmallResult category1Level(@RequestBody Map map) {
        if (map.size() < 2) {
            return TenmallResult.error(MessageEnum.VARIABLE_MISS_ERROR);
        } else {
            List<WxTabCategoryReportEntity> categoryReportEntityList = reportService.findByCountDate(
                    (String) map.get("beginDate"), (String) map.get("endDate")
            );
            return TenmallResult.success(MessageEnum.ACTION_SUCCESS, categoryReportEntityList);
        }
    }
}

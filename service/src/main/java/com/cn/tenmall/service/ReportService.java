package com.cn.tenmall.service;

import com.cn.tenmall.entity.WxTabCategoryReportEntity;

import java.util.List;

/**
 * @author luoyuequan
 * @time 2019/11/22 16:56
 */
public interface ReportService {
    List<WxTabCategoryReportEntity> findByCountDate(String beginDate, String endDate);
}

package com.cn.tenmall.service;

import com.cn.tenmall.vo.TenmallResult;

/**
 * @author luoyuequan
 * @time 2019/11/22 16:56
 */
public interface ReportService {
    /**
     * @param beginDate
     * @param endDate
     * @return
     */
    TenmallResult findByCountDate(String beginDate, String endDate);
}

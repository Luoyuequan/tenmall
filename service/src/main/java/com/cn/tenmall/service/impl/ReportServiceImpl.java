package com.cn.tenmall.service.impl;

import com.cn.tenmall.dao.CategoryReportDao;
import com.cn.tenmall.entity.WxTabCategoryReportEntity;
import com.cn.tenmall.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luoyuequan
 * @time 2019/11/22 16:56
 */
@Service
public class ReportServiceImpl implements ReportService {
    private final CategoryReportDao categoryReportDao;

    public ReportServiceImpl(CategoryReportDao categoryReportDao) {
        this.categoryReportDao = categoryReportDao;
    }

    @Override
    public List<WxTabCategoryReportEntity> findByCountDate(String beginDate, String endDate) {
        return categoryReportDao.findByCountDate(beginDate, endDate);
    }
}

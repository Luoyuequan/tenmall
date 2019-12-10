package com.cn.tenmall.service.impl;

import com.cn.tenmall.dao.CategoryReportDao;
import com.cn.tenmall.entity.WxTabCategoryReportEntity;
import com.cn.tenmall.enumClass.MessageEnum;
import com.cn.tenmall.service.ReportService;
import com.cn.tenmall.service.exception.ServiceException;
import com.cn.tenmall.vo.TenmallResult;
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
    public TenmallResult findByCountDate(String beginDate, String endDate) {
        try {
            List<WxTabCategoryReportEntity> categoryReportEntityList = categoryReportDao.findByCountDate(beginDate, endDate);
            return TenmallResult.success(MessageEnum.FIND_SUCCESS, categoryReportEntityList);
        } catch (ServiceException e) {
            return TenmallResult.error(MessageEnum.FIND_ERROR);
        }
    }
}

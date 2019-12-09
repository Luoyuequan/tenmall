package com.cn.tenmall.dao;

import com.cn.tenmall.entity.WxTabCategoryReportEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luoyuequan
 * @time 2019/12/9 17:19
 */
@Repository
public interface CategoryReportDao extends PublicDao<WxTabCategoryReportEntity> {
    /**
     * 添加 统计结果
     *
     * @param wxTabCategoryReportEntity 存储统计数据表
     * @return 添加结果
     */
    int insert(WxTabCategoryReportEntity wxTabCategoryReportEntity);

    /**
     * 修改统计结果
     *
     * @param wxTabCategoryReportEntity 存储统计数据表
     * @return 修改结果
     */
    int updateByPrimaryKey(WxTabCategoryReportEntity wxTabCategoryReportEntity);

    /**
     * 删除指定统计结果
     *
     * @param wxTabCategoryReportEntity
     * @return
     */
    int deleteByPrimaryKey(WxTabCategoryReportEntity wxTabCategoryReportEntity);

    /**
     * 根据给定时间段 查看
     *
     * @param beginDate 开始时间
     * @param endDate   结束时间
     * @return 统计结果
     */
    List<WxTabCategoryReportEntity> findByCountDate(@Param("beginDate") String beginDate, @Param("endDate") String endDate);
}

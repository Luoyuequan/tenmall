package com.cn.tenmall.dao;

import com.cn.tenmall.entity.WxTabOrderConfigEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 订单设置表
 * 系统通过定时任务处理超过半小时未支付的订单
 * </p>
 *
 * @author luoyuequan
 * @date 2019/12/8
 * @time 17:20
 */
@Repository
public interface OrderConfigDao extends PublicDao<WxTabOrderConfigEntity> {
    String TABLE_NAME = "wx_tab_order_config";

    /**
     * 订单相关设置信息 添加
     *
     * @param wxTabOrderConfigEntity 订单设置信息 实体
     * @return 添加结果
     */
    int insert(WxTabOrderConfigEntity wxTabOrderConfigEntity);

    /**
     * 根据订单设置表 id 查询 信息
     *
     * @param wxTabOrderConfigEntity 订单设置信息 实体
     * @return 查询结果 订单设置表
     */
    default WxTabOrderConfigEntity findById(WxTabOrderConfigEntity wxTabOrderConfigEntity) {
        return findByColumnForOnlyValue(TABLE_NAME, "id", wxTabOrderConfigEntity.getId());
    }

    /**
     * 查询所有订单设置表信息 无分页
     *
     * @param wxTabOrderConfigEntity 订单设置信息 实体
     * @return 查询结果 订单设置表
     */
    default List<WxTabOrderConfigEntity> findAll(WxTabOrderConfigEntity wxTabOrderConfigEntity) {
        return findAll(TABLE_NAME);
    }
}

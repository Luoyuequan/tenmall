package com.cn.tenmall.dao;

import com.cn.tenmall.entity.WxTabOrderItemEntity;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author luoyuequan
 * @time 2019/12/6 16:58
 */
@Repository
public interface OrderItemDao extends PublicDao<WxTabOrderItemEntity> {
    String TABLE_NAME = "wx_tab_order_item";

    /**
     * 查询订单详细表信息
     * 通过id
     *
     * @param wxTabOrderItemEntity 订单详细表实体
     * @return 订单详细表信息
     */
    default WxTabOrderItemEntity findById(WxTabOrderItemEntity wxTabOrderItemEntity) {
        return findByColumnForOnlyValue(TABLE_NAME, "id", wxTabOrderItemEntity.getId());
    }


    /**
     * 根据订单主表id in查询和CategoryId1分类，获取所有的订单详细表并统计PayMoney和数量
     *
     * @param orderIds 订单主表id 集合
     * @return 统计结果
     */
    List<Map> countPayMoneyAndNumberByOrderIdInGroupByCategoryId1(Collection orderIds);

    /**
     * 根据订单主表id
     * 查询订单详细表信息
     *
     * @param wxTabOrderItemEntity 订单详细表实体
     * @return 订单详细表信息集合
     */
    default List<WxTabOrderItemEntity> findByOrderId(WxTabOrderItemEntity wxTabOrderItemEntity) {
        return findByColumn(TABLE_NAME, "order_id", wxTabOrderItemEntity.getOrderId());
    }

    /**
     * 添加订单详细表信息
     *
     * @param wxTabOrderItemEntity 订单详细表实体
     * @return 添加结果 影响行数
     */
    int insert(WxTabOrderItemEntity wxTabOrderItemEntity);

    /**
     * 修改订单详细表信息
     * 通过id
     *
     * @param wxTabOrderItemEntity 订单详细表实体
     * @return 修改结果 影响行数
     */
    int updateById(WxTabOrderItemEntity wxTabOrderItemEntity);

    /**
     * 删除订单详细表 根据id
     *
     * @param wxTabOrderItemEntity 订单详细表实体
     * @return 删除结果 影响行数
     */
    default int deleteById(WxTabOrderItemEntity wxTabOrderItemEntity) {
        return physicalDeleteByColumn(TABLE_NAME, "id", wxTabOrderItemEntity.getId());
    }

    /**
     * 删除订单详细表 根据orderId
     *
     * @param wxTabOrderItemEntity 订单详细表实体
     * @return 删除结果 影响行数
     */
    default int deleteByOrderId(WxTabOrderItemEntity wxTabOrderItemEntity) {
        return physicalDeleteByColumn(TABLE_NAME, "order_id", wxTabOrderItemEntity.getOrderId());
    }
}

package com.cn.tenmall.dao;

import com.cn.tenmall.entity.WxTabOrderItemEntity;

/**
 * @author luoyuequan
 * @time 2019/12/6 16:58
 */
public interface WxTabOrderItemDao extends PublicDao<WxTabOrderItemEntity> {
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
}

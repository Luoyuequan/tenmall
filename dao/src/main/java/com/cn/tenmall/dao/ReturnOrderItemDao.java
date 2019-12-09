package com.cn.tenmall.dao;

import com.cn.tenmall.entity.WxTabReturnOrderItemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luoyuequan
 * @time 2019.12.8
 * @see com.cn.tenmall.dao.PublicDao
 */
@Repository
public interface ReturnOrderItemDao extends PublicDao<WxTabReturnOrderItemEntity> {
    String TABLE_NAME = "wx_tab_return_order_item";

    /**
     * 添加退货退款申请表详细信息
     *
     * @param wxTabReturnOrderItemEntity 退款退货详细表 实体
     * @return 添加结果
     */
    int insert(WxTabReturnOrderItemEntity wxTabReturnOrderItemEntity);

    /**
     * 修改退货退款申请表详细信息
     *
     * @param wxTabReturnOrderItemEntity 退款退货详细表 实体
     * @return 修改结果
     */
    int updateById(WxTabReturnOrderItemEntity wxTabReturnOrderItemEntity);

    /**
     * 根据退款退货表id 查询 详细表信息
     *
     * @param wxTabReturnOrderItemEntity 退款退货详细表 实体
     * @return 详细表信息集合
     */
    default List<WxTabReturnOrderItemEntity> findByReturnOrderId(WxTabReturnOrderItemEntity wxTabReturnOrderItemEntity) {
        return findByColumn(TABLE_NAME, "return_order_id", wxTabReturnOrderItemEntity.getReturnOrderId());
    }

    /**
     * 根据退款退货表id 删除 详细表信息
     *
     * @param wxTabReturnOrderItemEntity 退款退货详细表 实体
     * @return 删除结果
     */
    default int deleteByReturnOrderId(WxTabReturnOrderItemEntity wxTabReturnOrderItemEntity) {
        return physicalDeleteByColumn(TABLE_NAME, "return_order_id", wxTabReturnOrderItemEntity.getReturnOrderId());
    }
}
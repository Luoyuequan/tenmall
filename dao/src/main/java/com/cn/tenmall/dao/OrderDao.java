package com.cn.tenmall.dao;

import com.cn.tenmall.entity.WxTabOrderEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luoyuequan
 * @time 2019/12/5 16:39
 */
@Repository
public interface OrderDao extends PublicDao<WxTabOrderEntity> {
    String TABLE_NAME = "wx_tab_order";

    /**
     * 查询订单主表信息 通过id
     *
     * @param wxTabOrderEntity 订单主表实体
     * @return 订单主表信息
     */
    default WxTabOrderEntity findById(WxTabOrderEntity wxTabOrderEntity) {
        return findByColumnForOnlyValue(TABLE_NAME, "id", wxTabOrderEntity.getId());
    }

    /**
     * 查询所有订单 无条件模式 无分页模式
     *
     * @return 订单主表信息集
     */
    default List<WxTabOrderEntity> findAll() {
        return findAll(TABLE_NAME);
    }

    /**
     * 查询所有订单 无条件模式 分页模式
     *
     * @param offset 偏移量
     * @param limit  限制量
     * @return 订单主表信息集
     */
    default List<WxTabOrderEntity> findAllOfPageModel(Object offset, Object limit) {
        return findAllOfPageModel(TABLE_NAME, offset, limit);
    }

    /**
     * 根据订单状态查询订单，分页模式
     *
     * @param wxTabOrderEntity 订单主表实体
     * @param offset           偏移量
     * @param limit            限制量
     * @return 订单主表信息集
     */
    default List<WxTabOrderEntity> findByOrderStatusOfPageModel(WxTabOrderEntity wxTabOrderEntity, Object offset, Object limit) {
        return findByColumnOfPageModel(TABLE_NAME, "order_status", wxTabOrderEntity.getOrderStatus(), offset, limit);
    }

    default List<WxTabOrderEntity> findByIdIn(Object collection) {
        return findByColumnIn(TABLE_NAME, "id", collection);
    }

    /**
     * 查询未支付已超时的订单
     *
     * @param orderTimeout 超时时间
     * @return 订单主表信息集
     */
    List<WxTabOrderEntity> findByPayStatusEqualsAndCreateTimeBeforeHalfhour(Integer orderTimeout);

    /**
     * 查询前天的所有订单主表
     *
     * @return 订单主表信息集
     */
    List<WxTabOrderEntity> findByCreateTimeBeforeYesterday();

    /**
     * 添加订单主表信息
     *
     * @param wxTabOrderEntity 订单主表实体
     * @return 添加结果 影响行数
     */
    int insert(WxTabOrderEntity wxTabOrderEntity);

    /**
     * 修改订单主表信息
     * 通过id
     *
     * @param wxTabOrderEntity 订单主表实体
     * @return 修改结果 影响行数
     */
    int updateById(WxTabOrderEntity wxTabOrderEntity);

    /**
     * 修改订单主表 订单状态
     *
     * @param wxTabOrderEntity 订单主表实体
     * @return 修改结果 影响行数
     */
    default int updateOrderStatusById(WxTabOrderEntity wxTabOrderEntity) {
        return updateById(wxTabOrderEntity);
    }

    /**
     * 通过id 将已逻辑删除的记录进行逻辑恢复
     *
     * @param wxTabOrderEntity 订单主表实体
     * @return 逻辑删除结果 影响行数
     */
    default int logicRestoreById(WxTabOrderEntity wxTabOrderEntity) {
        wxTabOrderEntity.setIsDelete(0);
        return updateById(wxTabOrderEntity);
    }

    /**
     * 通过id 逻辑删除（软删除）
     *
     * @param wxTabOrderEntity 订单主表实体
     * @return 逻辑删除结果 影响行数
     */
    default int logicDeleteById(WxTabOrderEntity wxTabOrderEntity) {
        wxTabOrderEntity.setIsDelete(1);
        return updateById(wxTabOrderEntity);
    }

    /**
     * 物理删除(硬删除) 通过id 删除
     *
     * @param wxTabOrderEntity 订单主表实体
     * @return 物理删除结果 影响行数
     */
    default int physicalDeleteById(WxTabOrderEntity wxTabOrderEntity) {
        return physicalDeleteByColumn(TABLE_NAME, "id", wxTabOrderEntity.getId());
    }
}

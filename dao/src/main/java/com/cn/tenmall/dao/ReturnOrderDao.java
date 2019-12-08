package com.cn.tenmall.dao;

import com.cn.tenmall.entity.WxTabReturnOrderEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luo
 */
@Repository
public interface ReturnOrderDao extends PublicDao<WxTabReturnOrderEntity> {
    String TABLE_NAME = "wx_tab_return_order";

    /**
     * 根据id 删除退款退货申请表
     *
     * @param wxTabReturnOrderEntity 退款退货申请表实体
     * @return 删除结果 影响行数
     */
    default int deleteById(WxTabReturnOrderEntity wxTabReturnOrderEntity) {
        return physicalDeleteByColumn(TABLE_NAME, "id", wxTabReturnOrderEntity.getId());
    }

    /**
     * 添加退款退货申请表
     *
     * @param wxTabReturnOrderEntity 退款退货申请表实体
     * @return 添加结果 影响行数
     */
    int insert(WxTabReturnOrderEntity wxTabReturnOrderEntity);

    /**
     * 修改退款退货申请表
     *
     * @param wxTabReturnOrderEntity 退款退货申请表实体
     * @return 修改结果 行数
     */
    int updateById(WxTabReturnOrderEntity wxTabReturnOrderEntity);

    /**
     * 修改退款退货申请表 申请状态
     *
     * @param wxTabReturnOrderEntity 退款退货申请表实体
     * @return 修改结果 行数
     */
    default int updateStatusById(WxTabReturnOrderEntity wxTabReturnOrderEntity) {
        return updateById(wxTabReturnOrderEntity);
    }

    /**
     * 查询退款退货申请表 无条件模式 分页模式
     *
     * @param offset 偏移量
     * @param limit  限制量
     * @return 申请表集合
     */
    default List<WxTabReturnOrderEntity> findAllOfPageModel(Object offset, Object limit) {
        return findAllOfPageModel(TABLE_NAME, offset, limit);
    }
}
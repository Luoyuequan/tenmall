package com.cn.tenmall.dao;

import com.cn.tenmall.entity.WxTabReturnCauseEntity;
import org.springframework.stereotype.Repository;

/**
 * @author luoyuequan
 */
@Repository
public interface ReturnCauseDao extends PublicDao {
    String TABLE_NAME = "wx_tab_return_cause";

    /**
     * 根据id 删除 退货退款原因 信息
     *
     * @param wxTabReturnCauseEntity 退款退货原因实体
     * @return 操作结果
     */
    default int deleteById(WxTabReturnCauseEntity wxTabReturnCauseEntity) {
        return physicalDeleteByColumn(TABLE_NAME, "id", wxTabReturnCauseEntity.getId());
    }

    /**
     * 添加退款退货原因
     *
     * @param wxTabReturnCauseEntity 退款退货原因实体
     * @return 操作结果
     */
    int insert(WxTabReturnCauseEntity wxTabReturnCauseEntity);

    /**
     * 根据id修改 原因表
     *
     * @param wxTabReturnCauseEntity 退款退货原因实体
     * @return 操作结果
     */
    int updateById(WxTabReturnCauseEntity wxTabReturnCauseEntity);

    /**
     * 根据id查询 原因表
     *
     * @param wxTabReturnCauseEntity 退款退货原因实体
     * @return 查询结果 原因表实体
     */
    default WxTabReturnCauseEntity findById(WxTabReturnCauseEntity wxTabReturnCauseEntity) {
        return (WxTabReturnCauseEntity) findByColumnForOnlyValue(TABLE_NAME, "id", wxTabReturnCauseEntity.getId());
    }
}
package com.cn.tenmall.dao;

import com.cn.tenmall.entity.WxTabReturnCauseEntity;

/**
 * @author luoyuequan
 */
public interface WxTabReturnCauseDao extends PublicDao<WxTabReturnCauseEntity> {
    String TABLE_NAME = "wx_tab_return_cause";

    /**
     * @param wxTabReturnCauseEntity
     * @return
     */
    default int deleteById(WxTabReturnCauseEntity wxTabReturnCauseEntity) {
        return physicalDeleteByColumn(TABLE_NAME, "id", wxTabReturnCauseEntity.getId());
    }

    /**
     * @param wxTabReturnCauseEntity
     * @return
     */
    int insert(WxTabReturnCauseEntity wxTabReturnCauseEntity);

    /**
     * @param wxTabReturnCauseEntity
     * @return
     */
    int updateById(WxTabReturnCauseEntity wxTabReturnCauseEntity);

    /**
     * @param wxTabReturnCauseEntity
     * @return
     */
    default WxTabReturnCauseEntity findById(WxTabReturnCauseEntity wxTabReturnCauseEntity) {
        return findByColumnForOnlyValue(TABLE_NAME, "id", wxTabReturnCauseEntity.getId());
    }
}
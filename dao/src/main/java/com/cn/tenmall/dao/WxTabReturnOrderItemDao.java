package com.cn.tenmall.dao;

import org.apache.ibatis.annotations.Param;
import user.model.WxTabReturnOrderItem;
import user.model.WxTabReturnOrderItemExample;

import java.util.List;

public interface WxTabReturnOrderItemDao {
    int countByExample(WxTabReturnOrderItemExample example);

    int deleteByExample(WxTabReturnOrderItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxTabReturnOrderItem record);

    int insertSelective(WxTabReturnOrderItem record);

    List<WxTabReturnOrderItem> selectByExample(WxTabReturnOrderItemExample example);

    WxTabReturnOrderItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxTabReturnOrderItem record, @Param("example") WxTabReturnOrderItemExample example);

    int updateByExample(@Param("record") WxTabReturnOrderItem record, @Param("example") WxTabReturnOrderItemExample example);

    int updateByPrimaryKeySelective(WxTabReturnOrderItem record);

    int updateByPrimaryKey(WxTabReturnOrderItem record);
}
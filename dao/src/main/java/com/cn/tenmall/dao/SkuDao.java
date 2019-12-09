package com.cn.tenmall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.tenmall.entity.WxTabSku;

import java.util.Map;

public interface SkuDao extends BaseMapper<WxTabSku> {
    /**
     * 新增sku
     *
     * @param o
     * @return
     */

    int add(Map o);

}

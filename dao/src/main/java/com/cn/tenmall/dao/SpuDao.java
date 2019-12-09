package com.cn.tenmall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.tenmall.entity.WxTabSpu;

import java.util.Map;

public interface SpuDao extends BaseMapper<WxTabSpu> {
    /**
     * 新增spu
     *
     * @param wxTabSpu
     * @return
     */
    int add(Map wxTabSpu);
}

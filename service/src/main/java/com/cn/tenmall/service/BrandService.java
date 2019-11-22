package com.cn.tenmall.service;

import com.cn.tenmall.entity.WxTabBrand;

import java.util.List;

public interface BrandService {
    /**
     * 查询所有
     *
     * @return
     */
    List<WxTabBrand> finAll();

    /**
     * 修改
     *
     * @param wxTabBrand
     * @return
     */
    void update(WxTabBrand wxTabBrand);

    /**
     * 新增
     *
     * @param wxTabBrand
     * @return
     */
    void add(WxTabBrand wxTabBrand);
}

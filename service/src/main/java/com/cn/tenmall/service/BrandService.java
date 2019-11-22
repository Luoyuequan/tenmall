package com.cn.tenmall.service;

import com.cn.tenmall.entity.WxTabBrand;
import com.cn.tenmall.vo.PageObject;
import com.cn.tenmall.vo.TenmallResult;

import java.util.List;

public interface BrandService {
    /**
     * 查询所有
     *
     * @return
     */
    TenmallResult finAll();

    /**
     * 修改
     *
     * @param wxTabBrand
     * @return
     */
    TenmallResult update(WxTabBrand wxTabBrand);

    /**
     * 新增
     *
     * @param wxTabBrand
     * @return
     */
    TenmallResult add(WxTabBrand wxTabBrand);

    /**
     * 分页查询+条件分页
     *
     * @param page
     * @param size
     * @param searchMap
     * @return
     */
    TenmallResult findPage(Integer page, Integer size, WxTabBrand searchMap);
}

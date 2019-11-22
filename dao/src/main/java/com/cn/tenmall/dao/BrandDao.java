package com.cn.tenmall.dao;

import com.cn.tenmall.entity.WxTabBrand;

import java.util.List;

public interface BrandDao {
    /**
     * 查询所有
     *
     * @return
     */
    List<WxTabBrand> finAll();

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 修改
     *
     * @param wxTabBrand
     * @return
     */
    int update(WxTabBrand wxTabBrand);

    /**
     * 新增
     *
     * @param wxTabBrand
     * @return
     */
    int add(WxTabBrand wxTabBrand);
}

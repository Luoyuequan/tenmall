package com.cn.tenmall.dao;

import com.cn.tenmall.entity.WxTabBrand;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface BrandDao {
    /**
     * 查询所有
     *
     * @return
     */
    List<WxTabBrand> finAll();

    /**
     * 分页查询+条件分页
     *
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    List<WxTabBrand> findPage(@Param("searchMap") WxTabBrand searchMap, @Param("page") Integer page, @Param("size") Integer size);

    /**
     * 查询数据总数据
     *
     * @return
     */
    int total(@Param("searchMap") WxTabBrand searchMap);

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

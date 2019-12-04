package com.cn.tenmall.service;

import com.cn.tenmall.entity.CategoryEntity;
import com.cn.tenmall.vo.TenmallResult;

public interface CategoryService {
    /**
     * 新增商品
     *
     * @param categoryEntity
     * @return
     */
    TenmallResult add(CategoryEntity categoryEntity);

    /**
     * 修改商品
     *
     * @param categoryEntity
     * @return
     */
    TenmallResult update(CategoryEntity categoryEntity);

    /**
     * 商品分类列表
     *
     * @return
     */
    TenmallResult findAll();

    /**
     * 根据父级显示列表
     *
     * @param parentId 父级ID
     * @return
     */
    TenmallResult findByParentId(Integer parentId);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    TenmallResult deleteById(Integer id);
}

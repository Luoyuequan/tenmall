package com.cn.tenmall.dao;

import com.cn.tenmall.entity.CategoryEntity;

import java.util.List;

public interface CategoryDao {
    /**
     * 商品新增
     *
     * @param categoryEntity
     * @return
     */
    int add(CategoryEntity categoryEntity);

    /**
     * 商品修改
     *
     * @param categoryEntity
     * @return
     */
    int update(CategoryEntity categoryEntity);

    /**
     * 商品分类列表
     *
     * @return
     */
    List<CategoryEntity> findAll();

    /**
     * 根据父级显示列表
     *
     * @return
     */
    List<CategoryEntity> findByParentId(Integer id);

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    int deleteById(Integer id);
}

package com.cn.tenmall.service;

import com.cn.tenmall.entity.ParaEntity;
import com.cn.tenmall.vo.TenmallResult;

public interface ParaService {

    /**
     * 新增
     *
     * @param paraEntity
     * @return
     */
    TenmallResult add(ParaEntity paraEntity);

    /**
     * 修改
     *
     * @param paraEntity
     * @return
     */
    TenmallResult updateById(ParaEntity paraEntity);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    TenmallResult deleteById(Integer id);

    /**
     * 查询
     *
     * @return
     */
    TenmallResult findAll();

    /**
     * 规格条件分页查询
     *
     * @param name
     * @param options
     * @param page
     * @param size
     * @return
     */
    TenmallResult findCondPage(String name, String options, Integer page, Integer size);
}

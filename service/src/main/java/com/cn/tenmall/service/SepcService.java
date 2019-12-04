package com.cn.tenmall.service;

import com.cn.tenmall.entity.SepcEntity;
import com.cn.tenmall.vo.TenmallResult;

public interface SepcService {
    /**
     * 新增
     *
     * @param sepcEntity
     * @return
     */
    TenmallResult add(SepcEntity sepcEntity);

    /**
     * 修改
     *
     * @param sepcEntity
     * @return
     */
    TenmallResult updateById(SepcEntity sepcEntity);

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

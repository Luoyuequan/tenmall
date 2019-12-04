package com.cn.tenmall.service;

import com.cn.tenmall.entity.TemplateEntity;
import com.cn.tenmall.vo.TenmallResult;

import java.util.List;
import java.util.Map;


public interface TemplateService {

    /**
     * 新增
     */
    TenmallResult add(String name);

    /**
     * 查询所有
     *
     * @return
     */
    TenmallResult findAll();

    /**
     * 修改
     *
     * @param
     * @return
     */

    TenmallResult update(Integer id, String name);

    /**
     * 模板条件分页查询
     *
     * @param page 页码
     * @param size 每页记录数
     * @param name 模板名称
     * @return
     */
    TenmallResult find(Integer page, Integer size, String name);

    /**
     * 删除
     *
     * @param id 模板id
     * @return
     */
    TenmallResult deleteById(Integer id);

    /**
     * 根据id查询模板名称
     *
     * @param id
     * @return
     */
    TenmallResult findName(Integer id);
}

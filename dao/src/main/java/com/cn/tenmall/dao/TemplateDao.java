package com.cn.tenmall.dao;


import com.cn.tenmall.entity.TemplateEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TemplateDao {
    /**
     * 新增模板
     *
     * @return
     */
    int add(String name);

    /**
     * 查询所有
     *
     * @return
     */
    List<TemplateEntity> findAll();

    /**
     * 修改
     *
     * @return
     */
    int update(@Param("id") Integer id, @Param("name") String name);

    /**
     * 查询总记录数
     *
     * @return
     */
    int total(String name);

    /**
     * 分页查询
     *
     * @param size 每页记录数
     * @param page 每页起始位置数据
     * @param name 条件模板名称
     * @return
     */
    List<TemplateEntity> find(@Param("page") Integer page, @Param("size") Integer size, @Param("name") String name);

    /**
     * 删除模板
     *
     * @param id 模板id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 根据id查询模板名称
     *
     * @param id
     * @return
     */
    String findName(Integer id);

    /**
     * 根据id修改规格数量
     *
     * @param id
     * @param specNum
     * @return
     */
    int updatesSpecNum(@Param("id") Integer id, @Param("specNum") Integer specNum);
}

package com.cn.tenmall.dao;

import com.cn.tenmall.entity.ParaEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParaDao {
    /**
     * 新增
     *
     * @param paraEntity
     * @return
     */
    int add(ParaEntity paraEntity);

    /**
     * 修改
     *
     * @param paraEntity
     * @return
     */
    int update(ParaEntity paraEntity);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 参数条件分页查询
     */
    List<ParaEntity> findCondPage(@Param("name") String name, @Param("options") String options, @Param("page") Integer page, @Param("size") Integer size);

    /**
     * 查询总记录数
     *
     * @param name
     * @param options
     * @return
     */
    int total(@Param("name") String name, @Param("options") String options);

    /**
     * 根据模板id查询 总数据
     *
     * @param templateId
     * @return
     */
    int paraTotalById(Integer templateId);
}

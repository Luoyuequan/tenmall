package com.cn.tenmall.dao;

import com.cn.tenmall.entity.SepcEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SepcDao {
    /**
     * 新增
     *
     * @param sepcEntity
     * @return
     */
    int add(SepcEntity sepcEntity);

    /**
     * 修改
     *
     * @param sepcEntity
     * @return
     */
    int updateById(SepcEntity sepcEntity);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 查询
     *
     * @return
     */
    List<SepcEntity> findAll();

    /**
     * 规格条件分页查询
     *
     * @return
     */
    List<SepcEntity> findCondPage(@Param("name") String name, @Param("options") String options, @Param("page") Integer page, @Param("size") Integer size);

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
    int specTotalById(Integer templateId);
}

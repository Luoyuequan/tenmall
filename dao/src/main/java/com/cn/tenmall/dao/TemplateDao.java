package com.cn.tenmall.dao;


import com.cn.tenmall.entity.TemplateEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TemplateDao {
    /**
     * 新增模板
     * @return
     */
    public int add( @Param("name") String name,@Param("spec_num") String spec_num,@Param("para_num") String para_num);


    List<Map> findAll();

    List<TemplateEntity> find();
}

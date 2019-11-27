package com.cn.tenmall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.tenmall.entity.WxTabAdmin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends BaseMapper<WxTabAdmin> {
    /**
     * 更改状态
     * @param loginName
     * @return
     */
    int updateStatus(String loginName,int status);
}

package com.cn.tenmall.service.admin;

import com.cn.tenmall.entity.WxTabAdmin;

import java.util.List;

public interface AdminService {
    List<WxTabAdmin> findAll();
    WxTabAdmin findByUserName(String loginName);
    /**
     * 更改为登录状态
     * @param loginName
     * @return
     */
    Integer loginStatus(String loginName);
    /**
     * 更改为退出状态
     * @param loginName
     * @return
     */
    Integer logoutStatus(String loginName);
    /**
     * 更改为删除状态
     * @param loginName
     * @return
     */
    Integer delStatus(String loginName);
}

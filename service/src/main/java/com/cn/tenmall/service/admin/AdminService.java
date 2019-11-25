package com.cn.tenmall.service.admin;

import com.cn.tenmall.entity.WxTabAdmin;

import java.util.List;

public interface AdminService {
    List<WxTabAdmin> findAll();
    WxTabAdmin findByUserName(String username);
}

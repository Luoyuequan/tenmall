package com.cn.tenmall.service.admin;

import com.cn.tenmall.entity.WxTabAdmin;
import com.cn.tenmall.vo.TenmallResult;

import java.io.Serializable;

public interface AdminService {
    TenmallResult login(String username, String password);

    TenmallResult out(String username);

    TenmallResult save(WxTabAdmin admin);

    TenmallResult modify(WxTabAdmin admin);

    TenmallResult delete(Serializable id);
}

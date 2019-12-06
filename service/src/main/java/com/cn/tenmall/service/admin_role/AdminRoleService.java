package com.cn.tenmall.service.admin_role;

import com.cn.tenmall.entity.WxAdminAndWxRole;
import com.cn.tenmall.vo.TenmallResult;

public interface AdminRoleService {
    TenmallResult save(WxAdminAndWxRole adminAndRole);
    TenmallResult remove(WxAdminAndWxRole adminAndRole);
}

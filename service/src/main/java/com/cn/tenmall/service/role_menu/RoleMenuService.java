package com.cn.tenmall.service.role_menu;

import com.cn.tenmall.entity.WxRoleAndWxMenu;
import com.cn.tenmall.vo.TenmallResult;

public interface RoleMenuService {
    TenmallResult save(WxRoleAndWxMenu roleAndWxMenu);
    TenmallResult remove(WxRoleAndWxMenu roleAndWxMenu);
}

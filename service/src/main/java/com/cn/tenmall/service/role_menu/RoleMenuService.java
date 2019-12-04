package com.cn.tenmall.service.role_menu;

import com.cn.tenmall.entity.WxRoleAndWxMenu;

public interface RoleMenuService {
    boolean save(WxRoleAndWxMenu roleAndWxMenu);
    boolean remove(WxRoleAndWxMenu roleAndWxMenu);
}

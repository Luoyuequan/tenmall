/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RoleMenuServiceImpl
 * Author:   Administrator
 * Date:     2019/11/28 14:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.tenmall.service.role_menu.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.tenmall.dao.RoleMenuDao;
import com.cn.tenmall.entity.WxRoleAndWxMenu;
import com.cn.tenmall.service.role_menu.RoleMenuService;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/11/28
 * @since 1.0.0
 */
@Service
public class RoleMenuServiceImpl implements RoleMenuService {
    private final RoleMenuDao roleMenuDao;

    public RoleMenuServiceImpl(RoleMenuDao roleMenuDao) {
        this.roleMenuDao = roleMenuDao;
    }

    @Override
    public boolean save(WxRoleAndWxMenu roleAndWxMenu) {
        WxRoleAndWxMenu w=new WxRoleAndWxMenu();
        QueryWrapper<WxRoleAndWxMenu> queryWrapper=getQWrapper(roleAndWxMenu);
        if(roleMenuDao.selectList(queryWrapper).size()>0){
            return false;
        }
        return roleMenuDao.insert(roleAndWxMenu) > 0;
    }

    @Override
    public boolean remove(WxRoleAndWxMenu roleAndWxMenu) {
        QueryWrapper<WxRoleAndWxMenu> queryWrapper=getQWrapper(roleAndWxMenu);
        if(roleMenuDao.selectList(queryWrapper).size()==0){
            return false;
        }
        return roleMenuDao.delete(queryWrapper)>0;
    }

    private QueryWrapper<WxRoleAndWxMenu> getQWrapper(WxRoleAndWxMenu roleAndWxMenu){
        QueryWrapper<WxRoleAndWxMenu> queryWrapper=new QueryWrapper<WxRoleAndWxMenu>();
        queryWrapper.eq("role_id",roleAndWxMenu.getRoleId());
        queryWrapper.eq("menu_id",roleAndWxMenu.getMenuId());
        return queryWrapper;
    }
}

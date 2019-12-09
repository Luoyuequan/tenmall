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
import com.cn.tenmall.dao.MenuDao;
import com.cn.tenmall.dao.RoleDao;
import com.cn.tenmall.dao.RoleMenuDao;
import com.cn.tenmall.entity.WxRoleAndWxMenu;
import com.cn.tenmall.enumClass.MessageEnum;
import com.cn.tenmall.service.exception.ServiceException;
import com.cn.tenmall.service.role_menu.RoleMenuService;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private RoleMenuDao roleMenuDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private MenuDao menuDao;

    @Override
    public TenmallResult save(WxRoleAndWxMenu roleAndWxMenu) {
        QueryWrapper<WxRoleAndWxMenu> queryWrapper = getQWrapper(roleAndWxMenu);
        if (roleMenuDao.selectList(queryWrapper).size() > 0) {
            return TenmallResult.build(1, "已存在");
        }
        if (roleMenuDao.insert(roleAndWxMenu) > 0) {
            return TenmallResult.ok();
        }
        throw new ServiceException(MessageEnum.ADD_ERROR.getMessage());

    }

    @Override
    public TenmallResult remove(WxRoleAndWxMenu roleAndWxMenu) {
        QueryWrapper<WxRoleAndWxMenu> queryWrapper = getQWrapper(roleAndWxMenu);
        if (roleMenuDao.selectList(queryWrapper).size() == 0) {
            return TenmallResult.build(1, "不存在");
        }
        if (roleMenuDao.delete(queryWrapper) > 0) {
            return TenmallResult.ok();
        }
        throw new ServiceException(MessageEnum.DELETE_ERROR.getMessage());
    }

    private QueryWrapper<WxRoleAndWxMenu> getQWrapper(WxRoleAndWxMenu roleAndWxMenu) {
        if (roleDao.selectById(roleAndWxMenu.getRoleId()) == null || menuDao.selectById(roleAndWxMenu.getMenuId()) == null) {
            throw new ServiceException(MessageEnum.FIND_ERROR.getMessage());
        }
        QueryWrapper<WxRoleAndWxMenu> queryWrapper = new QueryWrapper<WxRoleAndWxMenu>();
        queryWrapper.eq("role_id", roleAndWxMenu.getRoleId());
        queryWrapper.eq("menu_id", roleAndWxMenu.getMenuId());
        return queryWrapper;
    }
}

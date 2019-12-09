/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MenuServiceImpl
 * Author:   Administrator
 * Date:     2019/11/26 15:07
 * Description: 菜单业务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.tenmall.service.menu.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cn.tenmall.dao.MenuDao;
import com.cn.tenmall.dao.RoleMenuDao;
import com.cn.tenmall.entity.WxRoleAndWxMenu;
import com.cn.tenmall.entity.WxTabMenu;
import com.cn.tenmall.enumClass.MessageEnum;
import com.cn.tenmall.service.exception.ServiceException;
import com.cn.tenmall.service.menu.MenuService;
import com.cn.tenmall.vo.PageObject;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈菜单业务〉
 *
 * @author Administrator
 * @create 2019/11/26
 * @since 1.0.0
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private RoleMenuDao roleMenuDao;

    @Override
    public TenmallResult findCondPage(String name, Integer current, Integer size) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("name", name);
        return TenmallResult.ok(new PageObject<>(menuDao.selectCount(null), menuDao.selectPage(new Page(current, size), queryWrapper).getRecords()));
    }

    @Override
    public TenmallResult findAll() {
        return TenmallResult.ok(menuDao.selectList(null));
    }

    @Override
    public TenmallResult save(WxTabMenu menu) {
        if (menuDao.insert(menu) > 0) {
            return TenmallResult.ok();
        }
        throw new ServiceException(MessageEnum.ADD_ERROR.getMessage());
    }

    @Override
    public TenmallResult modify(WxTabMenu menu) {
        if (menuDao.updateById(menu) > 0) {
            return TenmallResult.ok();
        }
        throw new ServiceException(MessageEnum.UPDATE_ERROR.getMessage());
    }

    @Override
    public TenmallResult delete(Serializable id) {
        if (menuDao.deleteById(id) > 0) {
            return TenmallResult.ok();
        }
        throw new ServiceException(MessageEnum.DELETE_ERROR.getMessage());
    }

    @Override
    public TenmallResult findAuthMenu(Long roleId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("role_id", roleId);
        List<WxRoleAndWxMenu> list = roleMenuDao.selectList(queryWrapper);
        List<WxTabMenu> menus = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            menus.add(menuDao.selectById(list.get(i).getMenuId()));
        }
        return TenmallResult.ok(menus);
    }


}

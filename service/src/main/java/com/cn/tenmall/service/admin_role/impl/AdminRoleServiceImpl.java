/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: AdminRoleServiceImpl
 * Author:   Administrator
 * Date:     2019/12/6 16:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.tenmall.service.admin_role.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.tenmall.dao.AdminDao;
import com.cn.tenmall.dao.AdminRoleDao;
import com.cn.tenmall.dao.RoleDao;
import com.cn.tenmall.entity.WxAdminAndWxRole;
import com.cn.tenmall.enumClass.MessageEnum;
import com.cn.tenmall.service.admin_role.AdminRoleService;
import com.cn.tenmall.service.exception.ServiceException;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/6
 * @since 1.0.0
 */
@Service
public class AdminRoleServiceImpl implements AdminRoleService {
    @Autowired
    private AdminRoleDao adminRoleDao;
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public TenmallResult save(WxAdminAndWxRole adminAndRole) {
        WxAdminAndWxRole w = new WxAdminAndWxRole();
        QueryWrapper<WxAdminAndWxRole> queryWrapper = getQWrapper(adminAndRole);
        if (adminRoleDao.selectList(queryWrapper).size() > 0) {
            return TenmallResult.build(1, "已存在");
        }
        if (adminRoleDao.insert(adminAndRole) > 0) {
            return TenmallResult.ok();
        }
        throw new ServiceException(MessageEnum.ADD_ERROR.getMessage());

    }

    @Override
    public TenmallResult remove(WxAdminAndWxRole adminAndRole) {
        QueryWrapper<WxAdminAndWxRole> queryWrapper = getQWrapper(adminAndRole);
        if (adminRoleDao.selectList(queryWrapper).size() == 0) {
            return TenmallResult.build(1, "不存在");
        }
        if (adminRoleDao.delete(queryWrapper) > 0) {
            return TenmallResult.ok();
        }
        throw new ServiceException(MessageEnum.DELETE_ERROR.getMessage());
    }

    private QueryWrapper<WxAdminAndWxRole> getQWrapper(WxAdminAndWxRole adminAndRole) {
        if (roleDao.selectById(adminAndRole.getRoleId()) == null || adminDao.selectById(adminAndRole.getAdminId()) == null) {
            throw new ServiceException(MessageEnum.FIND_ERROR.getMessage());
        }
        QueryWrapper<WxAdminAndWxRole> queryWrapper = new QueryWrapper<WxAdminAndWxRole>();
        queryWrapper.eq("role_id", adminAndRole.getRoleId());
        queryWrapper.eq("admin_id", adminAndRole.getAdminId());
        return queryWrapper;
    }
}

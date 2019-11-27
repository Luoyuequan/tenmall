/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RoleServiceImpl
 * Author:   Administrator
 * Date:     2019/11/27 14:41
 * Description: 角色业务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.tenmall.service.role.impl;

import com.cn.tenmall.dao.RoleDao;
import com.cn.tenmall.entity.WxTabRole;
import com.cn.tenmall.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈角色业务〉
 *
 * @author Administrator
 * @create 2019/11/27
 * @since 1.0.0
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public boolean save(WxTabRole role) {
        if(roleDao.insert(role)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean modify(WxTabRole role) {
        if(roleDao.updateById(role)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Serializable id) {
        if(roleDao.deleteById(id)>0){
            return true;
        }
        return false;
    }

    @Override
    public List<WxTabRole> findAll() {
        return roleDao.selectList(null);
    }
}

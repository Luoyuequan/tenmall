/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: AdminServiceImpl
 * Author:   Administrator
 * Date:     2019/11/22 15:33
 * Description: 管理员业务层
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.tenmall.service.admin.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.tenmall.dao.AdminDao;
import com.cn.tenmall.entity.WxTabAdmin;
import com.cn.tenmall.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈管理员业务层〉
 *
 * @author Administrator
 * @create 2019/11/22
 * @since 1.0.0
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public List<WxTabAdmin> findAll() {
        List<WxTabAdmin> list=adminDao.selectList(null);
        return list;
    }

    @Override
    public WxTabAdmin findByUserName(String loginName) {
        Map<String,Object> m = new HashMap<>();
        m.put("login_name",loginName);
        WxTabAdmin w= adminDao.selectByMap(m).get(0);
        if(w!=null){
            return w;
        }
        return null;
    }

    /**
     * 更改为登录状态
     * @param loginName
     * @return
     */
    @Override
    public Integer loginStatus(String loginName) {
        return adminDao.updateStatus(loginName,0);
    }
    /**
     * 更改为冻结状态
     * @param loginName
     * @return
     */
    @Override
    public Integer logoutStatus(String loginName) {
        return adminDao.updateStatus(loginName,1);
    }
    /**
     * 更改为删除状态
     * @param loginName
     * @return
     */
    @Override
    public Integer delStatus(String loginName) {
        return adminDao.updateStatus(loginName,2);
    }
}

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
import com.cn.tenmall.enumClass.MessageEnum;
import com.cn.tenmall.service.admin.AdminService;
import com.cn.tenmall.service.exception.ServiceException;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

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
    public TenmallResult login(String username, String password) {
        WxTabAdmin admin = findByUserName(username);
        if (admin != null) {
            if ((admin.getPassword()).equals(password.trim())) {
                admin.setStatus(1);
                if (adminDao.updateById(admin) > 0) {
                    return TenmallResult.ok();
                }
                throw new ServiceException(MessageEnum.UPDATE_ERROR.getMessage());
            }
            return TenmallResult.build(1,"密码错误");
        }
        return TenmallResult.build(0,"用户名错误");
    }

    @Override
    public TenmallResult out(String username) {
        WxTabAdmin admin = findByUserName(username);
        if(admin!=null){
            admin.setStatus(2);
            if (adminDao.updateById(admin) > 0) {
                return TenmallResult.ok();
            }
            throw new ServiceException(MessageEnum.UPDATE_ERROR.getMessage());
        }
        return TenmallResult.build(0,"用户名错误");
    }
    @Override
    public TenmallResult save(WxTabAdmin admin) {
        if(adminDao.insert(admin)>0){
            return TenmallResult.ok();
        }
        throw new ServiceException(MessageEnum.ADD_ERROR.getMessage());
    }
    @Override
    public TenmallResult modify(WxTabAdmin admin) {
        if(adminDao.updateById(admin)>0){
            return TenmallResult.ok();
        }
        throw new ServiceException(MessageEnum.UPDATE_ERROR.getMessage());
    }

    @Override
    public TenmallResult delete(Serializable id) {
        if(adminDao.deleteById(id)>0){
            return TenmallResult.ok();
        }
        throw new ServiceException(MessageEnum.ADD_ERROR.getMessage());
    }
    /**
     * 根据username获取对象
     * @param username 管理员名
     * @return
     */
    private WxTabAdmin findByUserName(String username) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("login_name",username);
        return (WxTabAdmin) adminDao.selectList(queryWrapper).get(0);
    }
}

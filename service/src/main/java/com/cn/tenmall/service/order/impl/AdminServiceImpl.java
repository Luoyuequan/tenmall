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
package com.cn.tenmall.service.order.impl;

import com.cn.tenmall.dao.AdminDao;
import com.cn.tenmall.entity.WxTabAdmin;
import com.cn.tenmall.service.order.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

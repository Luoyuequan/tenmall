/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: AdminController
 * Author:   Administrator
 * Date:     2019/11/21 17:13
 * Description: 管理控制层
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.tenmall.controller.admin;

import com.cn.tenmall.entity.WxTabAdmin;
import com.cn.tenmall.service.admin.AdminService;
import com.cn.tenmall.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈管理控制层〉
 *
 * @author Administrator
 * @create 2019/11/21
 * @since 1.0.0
 */
@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostMapping("login")
    public Message adminLogin(@Param("username")String username, @Param("password")String password){
        WxTabAdmin admin = adminService.findByUserName(username);
        if(admin!=null){
            if((admin.getPassword()).equals(password.trim())){
                return new Message("0","登录成功");
            }
        }
//        adminService.findAll();
        return new Message("0","登录失败");
    }
}


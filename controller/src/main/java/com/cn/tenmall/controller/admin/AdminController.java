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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    /**
     * @param username
     * @param password
     * @return
     */
    @PostMapping("login")
    public Message adminLogin(@Param("username") String username, @Param("password") String password) {

        WxTabAdmin admin = adminService.findByUserName(username);
        if (admin != null) {
            if ((admin.getPassword()).equals(password.trim())) {
                if (adminService.loginStatus(username) > 0) {
                    return new Message("0", "登录成功");
                }
            }
        }
        return new Message("0", "登录失败");
    }

    @PostMapping("logout")
    public Message adminOut(@Param("username") String username) {
        if(NotValue(username)!=null){
            return NotValue(username);
        }
        if (adminService.logoutStatus(username) > 0) {
            return new Message("0", "退出成功");
        }
        return new Message("0", "退出失败");
    }

    private Message NotValue(String username){
        return NotValue(username,"");
    }
    private Message NotValue(String username,String password){
        if (username == null) {
            return new Message("0", "username不能没空");
        } else if (password == null) {
            return new Message("0", "password不能没空");
        }
        return null;
    }
}


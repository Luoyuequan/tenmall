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
import com.cn.tenmall.service.order.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("login")
    public void adminLogin(@Param("username")String username,@Param("password")String password){
        List<WxTabAdmin> list=adminService.findAll();

    }
}
class AdminMessage{
    private String code;
    private String message;
}

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
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
     * 账号登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("login")
    public TenmallResult adminLogin(@RequestParam String username, @RequestParam String password) {
        return adminService.login(username, password);
    }

    /**
     * 账号退出
     * @param username
     * @return
     */
    @PostMapping("logout")
    public TenmallResult adminOut(@RequestParam String username) {
        return adminService.out(username);
    }
    /**
     * 管理员新增接口
     * @param admin 管理员对象
     * @return
     */
    @PostMapping("add")
    public TenmallResult add(@Valid WxTabAdmin admin){
        return adminService.save(admin);
    }

    /**
     * 管理员修改接口
     * @param admin 管理员对象
     * @return
     */
    @PostMapping("update")
    public TenmallResult update(@Valid WxTabAdmin admin){
        return adminService.modify(admin);
    }

    /**
     * 管理员删除接口
     * @param id id
     * @return
     */
    @PostMapping("delete")
    public TenmallResult delete(@RequestParam Long id){
        return adminService.delete(id);
    }

}


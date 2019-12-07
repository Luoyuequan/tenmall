/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: AdminRoleController
 * Author:   Administrator
 * Date:     2019/12/6 15:47
 * Description: 管理角色
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.tenmall.controller.admin_role;

import com.cn.tenmall.entity.WxAdminAndWxRole;
import com.cn.tenmall.service.admin_role.AdminRoleService;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 〈一句话功能简述〉<br> 
 * 〈管理角色〉
 *
 * @author Administrator
 * @create 2019/12/6
 * @since 1.0.0
 */
@RestController
@RequestMapping("adminRole")
public class AdminRoleController {
    @Autowired
    private AdminRoleService adminRoleService;

    @PostMapping("add")
    public TenmallResult add(@Valid WxAdminAndWxRole adminAndRole){
        return adminRoleService.save(adminAndRole);
    }
    @PostMapping("delete")
    public TenmallResult delete(@Valid WxAdminAndWxRole adminAndRole){
        return adminRoleService.remove(adminAndRole);
    }
}

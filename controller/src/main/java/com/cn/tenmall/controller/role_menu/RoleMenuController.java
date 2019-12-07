/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RoleMenuController
 * Author:   Administrator
 * Date:     2019/11/28 14:24
 * Description: 角色和菜单关联表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.tenmall.controller.role_menu;

import com.cn.tenmall.entity.WxRoleAndWxMenu;
import com.cn.tenmall.enumClass.MessageEnum;
import com.cn.tenmall.service.exception.ServiceException;
import com.cn.tenmall.service.role_menu.RoleMenuService;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 〈一句话功能简述〉<br> 
 * 〈角色和菜单关联表〉
 *
 * @author Administrator
 * @create 2019/11/28
 * @since 1.0.0
 */
@RestController
@RequestMapping("roleMenu")
public class RoleMenuController {
    @Autowired
    private  RoleMenuService roleMenuService;

    @PostMapping("add")
    public TenmallResult add(@Valid WxRoleAndWxMenu roleAndWxMenu){

        return roleMenuService.save(roleAndWxMenu);
    }
    @PostMapping("delete")
    public TenmallResult delete(@Valid WxRoleAndWxMenu roleAndWxMenu){
        return roleMenuService.remove(roleAndWxMenu);
    }
}

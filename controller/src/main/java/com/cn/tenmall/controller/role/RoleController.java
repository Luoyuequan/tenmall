/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RoleController
 * Author:   Administrator
 * Date:     2019/11/27 14:44
 * Description: 角色控制
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.tenmall.controller.role;

import com.cn.tenmall.entity.WxTabRole;
import com.cn.tenmall.service.role.RoleService;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 〈一句话功能简述〉<br> 
 * 〈角色控制〉
 *
 * @author Administrator
 * @create 2019/11/27
 * @since 1.0.0
 */
@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     *
     * @param role
     * @return
     */
    @PostMapping("add")
    public TenmallResult add(@Valid WxTabRole role){
        return roleService.save(role);
    }

    /**
     *
     * @param role
     * @return
     */
    @PostMapping("update")
    public TenmallResult update(@Valid WxTabRole role){

        return roleService.modify(role);
    }

    /**
     *
     * @param id
     * @return
     */
    @PostMapping("delete")
    public TenmallResult delete(@RequestParam Long id){
        return roleService.remove(id);
    }

    /**
     *
     * @return
     */
    @PostMapping("findAll")
    public TenmallResult findAll(){
        return roleService.findAll();
    }


}

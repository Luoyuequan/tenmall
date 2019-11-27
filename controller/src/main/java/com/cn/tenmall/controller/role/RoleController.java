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
import com.cn.tenmall.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public Message add(WxTabRole role){
        if(roleService.save(role)){
            return new Message("0","新增成功");
        }
        return new Message("0","新增成功");
    }

    /**
     *
     * @param role
     * @return
     */
    @PostMapping("update")
    public Message update(WxTabRole role){
        if(roleService.modify(role)) {
            return new Message("0", "修改成功");
        }
        return new Message("0","修改失败");
    }

    /**
     *
     * @param id
     * @return
     */
    @PostMapping("delete")
    public Message delete(@RequestParam("id") Long id){
        if(roleService.remove(id)) {
            return new Message("0", "删除成功");
        }
        return new Message("0","删除失败");
    }

    /**
     *
     * @return
     */
    @PostMapping("findAll")
    public List<WxTabRole> findAll(){
        return roleService.findAll();
    }


}

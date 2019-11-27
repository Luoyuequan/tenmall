/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MenuController
 * Author:   Administrator
 * Date:     2019/11/26 14:29
 * Description: 菜单Controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.tenmall.controller.menu;

import com.cn.tenmall.entity.WxTabMenu;
import com.cn.tenmall.service.menu.MenuService;
import com.cn.tenmall.vo.Message;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈菜单Controller〉
 *
 * @author Administrator
 * @create 2019/11/26
 * @since 1.0.0
 */
@Api(tags = "菜单接口")
@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    /**
     * 获取条件菜单列表接口
     * @param name 菜单名称
     * @param current 页码
     * @param size 每页记录数
     * @return
     */

    @PostMapping("findCondMenu")
    public List<WxTabMenu> findCondMenu(@RequestParam("name")String name, @RequestParam("page")Integer current, @RequestParam("size")Integer size){
        List<WxTabMenu> all = menuService.findAll(name, current, size);
        return all;
    }

    /**
     * 获取所有菜单列表接口
     * @param name 菜单名称
     * @return
     */
    @PostMapping("findAllMenu")
    public List<WxTabMenu> findAllMenu(@RequestParam("name")String name){
        List<WxTabMenu> all = menuService.findAll(name);
        return all;
    }

    /**
     * 获取权限范围内菜单列表接口
     * @param name
     * @return
     */
    @PostMapping("findAuthMenu")
    public List<WxTabMenu> findAuthMenu(@RequestParam("name")String name){
        List<WxTabMenu> all = menuService.findAll(name);
        return all;
    }

    /**
     * 菜单新增接口
     * @return
     */
    @PostMapping("add")
    public Message add(WxTabMenu menu){
        if(menuService.save(menu)){
            return new Message("0","新增成功");
        }
        return new Message("0","新增失败");
    }

    /**
     * 菜单新增接口
     * @return
     */
    @PostMapping("update")
    public Message update(WxTabMenu menu){
        if(menuService.modify(menu)){
            return new Message("0","修改成功");
        }
        return new Message("0","修改失败");
    }
    @PostMapping("delete")
    public Message delete(@RequestParam("id") Long id){

        if(menuService.delete(id)){
            return new Message("0","删除成功");
        }
        return new Message("0","删除失败");
    }

}

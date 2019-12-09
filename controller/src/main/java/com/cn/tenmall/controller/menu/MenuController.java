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
import com.cn.tenmall.vo.TenmallResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
     *
     * @param name    菜单名称
     * @param current 页码
     * @param size    每页记录数
     * @return
     */

    @PostMapping("findCondPage")
    public TenmallResult findCondPage(@RequestParam("name") String name, @RequestParam("page") Integer current, @RequestParam("size") Integer size) {
        return menuService.findCondPage(name, current, size);
    }


    /**
     * 获取所有菜单列表接口
     *
     * @return
     */
    @PostMapping("findAll")
    public TenmallResult findAll() {
        return menuService.findAll();
    }

    /**
     * 获取权限范围内菜单列表接口
     *
     * @return
     */
    @PostMapping("findAuthMenu")
    public TenmallResult findAuthMenu(@RequestParam Long roleId) {
        return menuService.findAuthMenu(roleId);
    }

    /**
     * 菜单新增接口
     *
     * @param menu 菜单对象
     * @return
     */
    @PostMapping("add")
    public TenmallResult add(@Valid WxTabMenu menu) {
        return menuService.save(menu);
    }

    /**
     * 菜单修改接口
     *
     * @param menu 菜单对象
     * @return
     */
    @PostMapping("update")
    public TenmallResult update(@Valid WxTabMenu menu) {
        return menuService.modify(menu);
    }

    /**
     * 菜单删除接口
     *
     * @param id id
     * @return
     */
    @PostMapping("delete")
    public TenmallResult delete(@RequestParam Long id) {
        return menuService.delete(id);
    }

}

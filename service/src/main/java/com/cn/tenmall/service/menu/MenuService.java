package com.cn.tenmall.service.menu;

import com.cn.tenmall.entity.WxTabMenu;
import com.cn.tenmall.vo.TenmallResult;

import java.io.Serializable;

public interface MenuService {
    TenmallResult findCondPage(String name, Integer current, Integer size);
    TenmallResult findAll();
    TenmallResult save(WxTabMenu menu);
    TenmallResult modify(WxTabMenu menu);
    TenmallResult delete(Serializable id);
    TenmallResult findAuthMenu(Long roleId);
}

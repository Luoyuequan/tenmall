package com.cn.tenmall.service.menu;

import com.cn.tenmall.entity.WxTabMenu;

import java.io.Serializable;
import java.util.List;

public interface MenuService {
    List<WxTabMenu> findAll(String name);
    List<WxTabMenu> findAll(String name, Integer current, Integer size);
    Boolean save(WxTabMenu menu);
    Boolean modify(WxTabMenu menu);
    Boolean delete(Serializable id);
}

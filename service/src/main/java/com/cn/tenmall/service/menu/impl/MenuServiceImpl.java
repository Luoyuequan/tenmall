/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MenuServiceImpl
 * Author:   Administrator
 * Date:     2019/11/26 15:07
 * Description: 菜单业务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.tenmall.service.menu.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cn.tenmall.dao.MenuDao;
import com.cn.tenmall.entity.WxTabMenu;
import com.cn.tenmall.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈菜单业务〉
 *
 * @author Administrator
 * @create 2019/11/26
 * @since 1.0.0
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    public List<WxTabMenu> findAll(String name){
        return findAll(name,null,null);
    }
    @Override
    public List<WxTabMenu> findAll(String name, Integer current, Integer size) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("name",name);
        List records=null;
        if(current!=null&&size!=null){
             IPage iPage= menuDao.selectPage(new Page(current, size), queryWrapper);
             records=iPage.getRecords();
        }else {
             records = menuDao.selectList(queryWrapper);
        }
        return records;
    }

    @Override
    public Boolean save(WxTabMenu menu) {
        if(menuDao.insert(menu)>0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean modify(WxTabMenu menu) {
        if (menuDao.updateById(menu)>0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(Serializable id) {
        if(menuDao.deleteById(id)>0){
            return true;
        }
        return false;
    }
}

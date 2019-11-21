package com.cn.tenmall.controller;

import com.cn.tenmall.dao.WxTabBrandDao;
import com.cn.tenmall.entity.WxTabBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class WxTabBrandController {

    @Autowired
    private WxTabBrandDao wxTabBrandDao;

    @RequestMapping("/findAll.do")
    public List<WxTabBrand> findAll() {
        List<WxTabBrand> wxTabBrands = wxTabBrandDao.finAll();
        System.out.println(wxTabBrands);
        return wxTabBrands;
    }
}

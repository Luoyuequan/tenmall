package com.cn.tenmall.controller;

import com.cn.tenmall.entity.WxTabBrand;
import com.cn.tenmall.service.BrandService;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class WxTabBrandController {

    @Autowired
    private BrandService brandService;

    //    查询所有
    @RequestMapping("/findAll")
    public List<WxTabBrand> findAll() {
        List<WxTabBrand> wxTabBrands = brandService.finAll();
        return wxTabBrands;
    }

    //修改
    @RequestMapping("/update")
    public String update(WxTabBrand wxTabBrand) {
        brandService.update(wxTabBrand);

        return "kk";
    }

    //新增
    @RequestMapping("/add")
    public String add(WxTabBrand wxTabBrand) {
        brandService.add(wxTabBrand);
        return "kkk";
    }
}

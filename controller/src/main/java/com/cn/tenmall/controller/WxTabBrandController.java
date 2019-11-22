package com.cn.tenmall.controller;

import com.cn.tenmall.entity.WxTabBrand;
import com.cn.tenmall.service.BrandService;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/brand")
public class WxTabBrandController {

    @Autowired
    private BrandService brandService;

    //    查询所有
    @RequestMapping("/findAll")
    public TenmallResult findAll() {
        TenmallResult tenmallResult = brandService.finAll();
        return tenmallResult;
    }

    // 分页查询&分页查询+条件查询
    @RequestMapping("/findPage")
    public TenmallResult findPage(Integer page, Integer size, WxTabBrand searchMap) {
        if (page == null || page == 0 || size == null) {
            return TenmallResult.build(400, "参数错误");
        }
        TenmallResult tenmallResult = brandService.findPage(page, size, searchMap);
        return tenmallResult;
    }

    //修改
    @RequestMapping("/update")
    public TenmallResult update(WxTabBrand wxTabBrand) {
        TenmallResult updateResult = brandService.update(wxTabBrand);
        return updateResult;
    }

    //新增
    @RequestMapping("/add")
    public TenmallResult add(WxTabBrand wxTabBrand) {
        TenmallResult addResult = brandService.add(wxTabBrand);
        return addResult;
    }
}

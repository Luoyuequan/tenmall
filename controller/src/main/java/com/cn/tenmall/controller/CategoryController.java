package com.cn.tenmall.controller;

import com.cn.tenmall.entity.CategoryEntity;
import com.cn.tenmall.service.CategoryService;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("add")
    public TenmallResult add(CategoryEntity categoryEntity) {
        return null;
    }
}

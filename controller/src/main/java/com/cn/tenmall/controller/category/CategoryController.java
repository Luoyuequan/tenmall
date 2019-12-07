package com.cn.tenmall.controller.category;

import com.cn.tenmall.entity.CategoryEntity;
import com.cn.tenmall.service.category.CategoryService;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("add")
    public TenmallResult add(@Valid CategoryEntity categoryEntity) {
        return categoryService.add(categoryEntity);
    }
    @RequestMapping("update")
    public TenmallResult update(@Valid CategoryEntity categoryEntity) {
        return categoryService.update(categoryEntity);
    }
    @RequestMapping("findAll")
    public TenmallResult findAll() {
        return categoryService.findAll();
    }
    @RequestMapping("findByParentId")
    public TenmallResult findByParentId(@RequestParam Integer parentId) {
        return categoryService.findByParentId(parentId);
    }
    @RequestMapping("delete")
    public TenmallResult delete(@RequestParam Integer id) {
        return categoryService.deleteById(id);
    }
}

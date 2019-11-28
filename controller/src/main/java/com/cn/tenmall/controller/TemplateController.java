package com.cn.tenmall.controller;


import com.cn.tenmall.entity.TemplateEntity;
import com.cn.tenmall.service.TemplateService;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模板管理
 */
@RestController
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    private TemplateService service;

    /**
     * 模板新增
     *
     * @param
     * @return
     */
    @RequestMapping(value = "add")
    public TenmallResult add(TemplateEntity templateEntity) {
        if (templateEntity == null || StringUtils.isEmpty(templateEntity.getName())) {
            return TenmallResult.build(1, "参数不能为空");
        }
        return service.add(templateEntity);
    }

    /**
     * 模板查询所有
     *
     * @return
     */
    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public TenmallResult findAll() {
//        return service.findAll();
        return service.findAll();
    }

    /**
     * 修改
     *
     * @return
     */
    @RequestMapping("update")
    public TenmallResult update(TemplateEntity templateEntity) {
        if (templateEntity == null || templateEntity.getId() == null) {
            return TenmallResult.build(1, "参数不能为空");
        }
        return service.update(templateEntity);
    }

    /**
     * 模板按条件进行查询
     *
     * @param
     * @return
     */
    @RequestMapping(value = "find", method = RequestMethod.GET)
    public TenmallResult find(Integer page, Integer size, String name) {
//        return service.find(map);
        if (page == null || page == 0 || size == null || StringUtils.isEmpty(name)) {
            return TenmallResult.build(1, "参数不能为空");
        }
        return service.find(page, size, name);
    }

    @RequestMapping("delete")
    public TenmallResult delete(Integer id) {
        if (id == null) {
            return TenmallResult.build(1, "参数不能为空");
        }
        return service.deleteById(id);
    }
}

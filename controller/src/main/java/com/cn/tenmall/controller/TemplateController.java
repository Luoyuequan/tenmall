package com.cn.tenmall.controller;


import com.cn.tenmall.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
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
 *
 */
@RestController
@RequestMapping("/template/*")
public class TemplateController {

    @Autowired
    private TemplateService service;

    /**
     * 模板新增
     * @param map
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Map add(@RequestBody Map map){
        return service.add(map);
    }

    /**
     * 模板查询所有
     * @return
     */
    @RequestMapping(value = "findAll",method= RequestMethod.GET)
    public List<Map> findAll(){
        return service.findAll();
    }

    /**
     * 模板按条件进行查询
     * @param map
     * @return
     */
    @RequestMapping(value = "find",method = RequestMethod.GET)
    public Map find(@RequestBody Map map){
        return service.find(map);
    }
}

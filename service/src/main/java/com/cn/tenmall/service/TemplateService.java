package com.cn.tenmall.service;

import java.util.List;
import java.util.Map;


public interface TemplateService {

    public Map add(Map map);

    List<Map> findAll();

    Map find(Map map);
}

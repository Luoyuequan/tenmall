package com.cn.tenmall.service.impl;

import com.cn.tenmall.dao.TemplateDao;
import com.cn.tenmall.entity.TemplateEntity;
import com.cn.tenmall.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    public TemplateDao dao;
    @Override
    public Map add(Map map) {
        String spec_num = "0";
        String para_num = "0";
        if (map.get("spec_num")!=null){
            spec_num = (String) map.get("spec_num");
        }
        if (map.get("para_num")!=null){
            para_num = (String) map.get("para_num");
        }
        int i = dao.add((String) map.get("name"),spec_num,para_num);
        Map result = new HashMap();
        if (i==1){
            result.put("code",0);
            result.put("message","保存成功");
        }else {
            result.put("code",1);
            result.put("message","保存失败");
        }
        System.out.println(i);
        return map;
    }

    @Override
    public List<Map> findAll() {
        return dao.findAll();
    }

    @Override
    public Map find(Map map) {
        Map<String, List<TemplateEntity>> map1 = new HashMap<>();
        List<TemplateEntity> list = dao.find();
        map1.put("rows",list);
        map1.put("total",);

        return null;
    }


}

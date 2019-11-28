package com.cn.tenmall.service.impl;

import com.cn.tenmall.dao.TemplateDao;
import com.cn.tenmall.entity.TemplateEntity;
import com.cn.tenmall.service.TemplateService;
import com.cn.tenmall.vo.PageObject;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    public TemplateDao templateDao;

    @Override
    public TenmallResult add(TemplateEntity templateEntity) {
        int i = templateDao.add(templateEntity);
        if (i < 1) {
            return TenmallResult.build(0, "新增失败");
        }
        return TenmallResult.ok();
    }

    @Override
    public TenmallResult findAll() {
        List<TemplateEntity> templateDaoAll = templateDao.findAll();
        if (templateDaoAll == null) {
            return TenmallResult.build(1, "查询失败");
        }
        return TenmallResult.ok(templateDaoAll);
    }

    @Override
    public TenmallResult update(TemplateEntity templateEntity) {
        int i = templateDao.update(templateEntity);
        if (i < 1) {
            return TenmallResult.build(1, "修改失败");
        }
        return TenmallResult.ok();
    }

    @Override
    public TenmallResult find(Integer page, Integer size, String name) {
        //查询总记录数
        int total = templateDao.total(name);
        if (total == 0) {
            return TenmallResult.build(1, "没有查询到响应的记录");
        }
        PageObject<TemplateEntity> pageObject = new PageObject<>();
        pageObject.setTotal(total);
        //设置sql分页起始位置
        int startIndex = (page - 1) * size;
        List<TemplateEntity> templateEntities = templateDao.find(startIndex, size, name);
        if (templateEntities == null || templateEntities.size() == 0) {
            return TenmallResult.build(1, "没有查询到对应的记录");
        }
        pageObject.setRows(templateEntities);
        return TenmallResult.ok(pageObject);
    }

    @Override
    public TenmallResult deleteById(Integer id) {
        int i = templateDao.deleteById(id);
        if (i < 1) {
            return TenmallResult.build(1, "删除失败");
        }
        return TenmallResult.ok();
    }


    //    @Override
//    public Map add(Map map) {
//        String spec_num = "0";
//        String para_num = "0";
//        if (map.get("spec_num")!=null){
//            spec_num = (String) map.get("spec_num");
//        }
//        if (map.get("para_num")!=null){
//            para_num = (String) map.get("para_num");
//        }
//        int i = dao.add((String) map.get("name"),spec_num,para_num);
//        Map result = new HashMap();
//        if (i==1){
//            result.put("code",0);
//            result.put("message","保存成功");
//        }else {
//            result.put("code",1);
//            result.put("message","保存失败");
//        }
//        System.out.println(i);
//        return map;
//    }
//
//    @Override
//    public List<Map> findAll() {
//        return dao.findAll();
//    }
//
//    @Override
//    public Map find(Map map) {
//        Map<String, List<TemplateEntity>> map1 = new HashMap<>();
//        List<TemplateEntity> list = dao.find();
//        map1.put("rows",list);
////        map1.put("total",);
//
//        return null;
//    }


}

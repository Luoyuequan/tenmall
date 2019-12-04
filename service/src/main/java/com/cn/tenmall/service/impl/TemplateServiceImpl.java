package com.cn.tenmall.service.impl;

import com.cn.tenmall.dao.ParaDao;
import com.cn.tenmall.dao.SepcDao;
import com.cn.tenmall.dao.TemplateDao;
import com.cn.tenmall.entity.TemplateEntity;
import com.cn.tenmall.enumClass.MessageEnum;
import com.cn.tenmall.service.TemplateService;
import com.cn.tenmall.service.exception.ServiceException;
import com.cn.tenmall.vo.PageObject;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class TemplateServiceImpl implements TemplateService {
    @Autowired
    public TemplateDao templateDao;
    @Autowired
    public ParaDao paraDao;
    @Autowired
    public SepcDao sepcDao;

    @Override
    public TenmallResult add(String name) {
        //查询规格数量
        //sepcDao.specTotalById()

        TemplateEntity templateEntity = new TemplateEntity();
        int i = templateDao.add(name);
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
    public TenmallResult update(Integer id, String name) {

        TemplateEntity templateEntity = new TemplateEntity();
        int i = templateDao.update(id, name);
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
        System.out.println(i);
        if (i <= 0) {
            return TenmallResult.build(1, "删除失败");
        }
        return TenmallResult.ok();
    }

    @Override
    public TenmallResult findName(Integer id) {
        String name = templateDao.findName(id);
        if (StringUtils.isEmpty(name)) {
            throw new ServiceException(MessageEnum.FIND_ERROR.getMessage());
        }
        return TenmallResult.ok(name);
    }
}

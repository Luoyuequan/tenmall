package com.cn.tenmall.service.impl;

import com.cn.tenmall.dao.ParaDao;
import com.cn.tenmall.entity.ParaEntity;
import com.cn.tenmall.service.ParaService;
import com.cn.tenmall.vo.PageObject;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParaServiceImpl implements ParaService {

    @Autowired
    private ParaDao paraDao;

    @Override
    public TenmallResult add(ParaEntity paraEntity) {
        int add = paraDao.add(paraEntity);
        if (add < 1) {
            return TenmallResult.build(1, "新增失败");
        }
        return TenmallResult.ok();
    }

    @Override
    public TenmallResult updateById(ParaEntity paraEntity) {
        int i = paraDao.update(paraEntity);
        if (i < 1) {
            return TenmallResult.build(1, "修改失败");
        }

        return TenmallResult.ok();
    }

    @Override
    public TenmallResult deleteById(Integer id) {
        int i = paraDao.deleteById(id);
        if (i < 1) {
            return TenmallResult.build(1, "删除失败");
        }
        return TenmallResult.ok();

    }

    @Override
    public TenmallResult findAll() {

        return null;
    }

    @Override
    public TenmallResult findCondPage(String name, String options, Integer page, Integer size) {
        int total = paraDao.total(name, options);
        if (total < 1) {
            return TenmallResult.build(1, "查询失败");
        }
        PageObject<ParaEntity> pageObject = new PageObject<>();
        //设置sql分页起始位置
        int startIndex = (page - 1) * size;
        List<ParaEntity> condPage = paraDao.findCondPage(name, options, startIndex, size);
        return TenmallResult.ok(condPage);
    }
}

package com.cn.tenmall.service.impl;

import com.cn.tenmall.dao.SepcDao;
import com.cn.tenmall.dao.TemplateDao;
import com.cn.tenmall.entity.SepcEntity;
import com.cn.tenmall.enumClass.MessageEnum;
import com.cn.tenmall.service.SepcService;
import com.cn.tenmall.service.exception.ServiceException;
import com.cn.tenmall.vo.PageObject;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SepcserviceImpl implements SepcService {
    @Autowired
    private SepcDao sepcDao;
    @Autowired
    private TemplateDao templateDao;

    @Override
    @Transactional
    public TenmallResult add(SepcEntity sepcEntity) {
        Integer templateId = sepcEntity.getTemplateId();
        //添加规格数据
        int add = sepcDao.add(sepcEntity);
        //根据模板id查询对应的规格数量
        int total = sepcDao.specTotalById(templateId);
        //根据模板id修改模板规格数量
        int i = templateDao.updatesSpecNum(templateId, total);
        if (add == 0) {
            throw new ServiceException(MessageEnum.ADD_ERROR.getMessage());
        }
        if (i == 0) {
            throw new ServiceException(MessageEnum.UPDATE_ERROR.getMessage());
        }
        return TenmallResult.ok();
    }

    @Override
    public TenmallResult updateById(SepcEntity sepcEntity) {
        int i = sepcDao.updateById(sepcEntity);
        if (i == 0) {
            return TenmallResult.build(1, "修改失败");
        }

        return TenmallResult.ok();
    }

    @Override
    public TenmallResult deleteById(Integer id) {
        int i = sepcDao.deleteById(id);
        if (i == 0) {
            return TenmallResult.build(1, "删除失败");
        }
        return TenmallResult.ok();
    }

    @Override
    public TenmallResult findAll() {
        List<SepcEntity> all = sepcDao.findAll();
        if (all == null || all.size() == 0) {
            return TenmallResult.build(1, "查询失败");
        }
        return TenmallResult.ok(all);
    }

    @Override
    public TenmallResult findCondPage(String name, String options, Integer page, Integer size) {
        int total = sepcDao.total(name, options);
        if (total < 1) {
            return TenmallResult.build(1, "查询失败");
        }
        PageObject<SepcEntity> pageObject = new PageObject<>();
        //设置sql分页起始位置
        int startIndex = (page - 1) * size;
        List<SepcEntity> condPage = sepcDao.findCondPage(name, options, startIndex, size);
        return TenmallResult.ok(condPage);
    }
}

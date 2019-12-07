package com.cn.tenmall.service.impl;

import com.cn.tenmall.dao.CategoryDao;
import com.cn.tenmall.entity.CategoryEntity;
import com.cn.tenmall.enumClass.MessageEnum;
import com.cn.tenmall.service.CategoryService;
import com.cn.tenmall.service.exception.ServiceException;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public TenmallResult add(CategoryEntity categoryEntity) {
        int add = categoryDao.add(categoryEntity);
        if (add < 1) {
            throw new ServiceException(MessageEnum.ADD_ERROR.getMessage());
        }
        return TenmallResult.ok();
    }

    @Override
    public TenmallResult update(CategoryEntity categoryEntity) {
        int update = categoryDao.update(categoryEntity);
        if (update < 1) {
            throw new ServiceException(MessageEnum.UPDATE_ERROR.getMessage());
        }
        return TenmallResult.ok();
    }

    @Override
    public TenmallResult findAll() {
        List<CategoryEntity> all = categoryDao.findAll();
        if (all == null || all.size() < 1) {
            throw new ServiceException(MessageEnum.FIND_ERROR.getMessage());
        }
        return TenmallResult.ok(all);
    }

    @Override
    public TenmallResult findByParentId(Integer parentId) {
        List<CategoryEntity> lists = categoryDao.findByParentId(parentId);
        if (lists == null || lists.size() < 1) {
            throw new ServiceException(MessageEnum.FIND_ERROR.getMessage());
        }
        return TenmallResult.ok(lists);
    }

    @Override
    public TenmallResult deleteById(Integer id) {
        int i = categoryDao.deleteById(id);
        if (i < 1) {
            throw new ServiceException(MessageEnum.DELETE_ERROR.getMessage());
        }
        return TenmallResult.ok();
    }
}

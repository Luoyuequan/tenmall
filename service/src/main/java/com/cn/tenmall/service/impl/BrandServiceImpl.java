package com.cn.tenmall.service.impl;

import com.cn.tenmall.dao.BrandDao;
import com.cn.tenmall.entity.WxTabBrand;
import com.cn.tenmall.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDao brandDao;

    @Override
    public List<WxTabBrand> finAll() {
        List<WxTabBrand> wxTabBrands = brandDao.finAll();
        return wxTabBrands;
    }

    @Override
    public void update(WxTabBrand wxTabBrand) {
        int update = brandDao.update(wxTabBrand);
    }

    @Override
    public void add(WxTabBrand wxTabBrand) {
        int add = brandDao.add(wxTabBrand);
    }
}

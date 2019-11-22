package com.cn.tenmall.service.impl;

import com.cn.tenmall.dao.BrandDao;
import com.cn.tenmall.entity.WxTabBrand;
import com.cn.tenmall.service.BrandService;
import com.cn.tenmall.vo.PageObject;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDao brandDao;

    @Override
    public TenmallResult finAll() {
        List<WxTabBrand> wxTabBrands = brandDao.finAll();
        if (wxTabBrands == null) {
            return TenmallResult.build(201, "查询失败");
        }
        return TenmallResult.ok(wxTabBrands);
    }

    @Override
    public TenmallResult update(WxTabBrand wxTabBrand) {

        int update = brandDao.update(wxTabBrand);
        if (update < 1) {

        }
        return TenmallResult.ok();
    }

    @Override
    public TenmallResult add(WxTabBrand wxTabBrand) {
        int add = brandDao.add(wxTabBrand);
        if (add < 1) {

        }
        return TenmallResult.ok();
    }

    @Override
    public TenmallResult findPage(Integer page, Integer size, WxTabBrand searchMap) {
        //查询总记录数
        int total = brandDao.total(searchMap);
        if (total == 0) {
            return TenmallResult.build(201, "没有查询到对应的数据");
        }
        PageObject<WxTabBrand> pageObject = new PageObject<>();
        pageObject.setTotal(total);
        //查询分页数据
        List<WxTabBrand> row = brandDao.findPage(searchMap, page, size);
        pageObject.setRows(row);
        return TenmallResult.ok(pageObject);
    }
}

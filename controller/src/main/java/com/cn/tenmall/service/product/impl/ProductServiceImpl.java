/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ProductServiceImpl
 * Author:   Administrator
 * Date:     2019/12/7 11:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.tenmall.service.product.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cn.tenmall.dao.SkuDao;
import com.cn.tenmall.dao.SpuDao;
import com.cn.tenmall.entity.WxTabSku;
import com.cn.tenmall.entity.WxTabSpu;
import com.cn.tenmall.enumClass.MessageEnum;
import com.cn.tenmall.service.exception.ServiceException;
import com.cn.tenmall.service.product.ProductService;
import com.cn.tenmall.vo.PageObject;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/7
 * @since 1.0.0
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private SkuDao skuDao;
    @Autowired
    private SpuDao spuDao;

    @Override
    public TenmallResult submitReq(Long id) {
        WxTabSpu wxTabSpu = spuDao.selectById(id);
        wxTabSpu.setStatus("9");
        if (spuDao.updateById(wxTabSpu) > 0) {
            return TenmallResult.ok();
        }
        throw new ServiceException(MessageEnum.UPDATE_ERROR.getMessage());
    }

    @Override
    public TenmallResult findAuditALL(Integer status, Integer page, Integer size) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("status", status);
        return TenmallResult.ok(new PageObject<>(spuDao.selectCount(null), spuDao.selectPage(new Page<>(page, size), queryWrapper).getRecords()));
    }

    @Override
    public TenmallResult auditReq(Long id) {
        WxTabSpu wxTabSpu = spuDao.selectById(1);
        wxTabSpu.setIsMarketable("1");
        wxTabSpu.setStatus("1");
        WxTabSku wxTabSku = new WxTabSku();
        wxTabSku.setStatus("1");
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("spu_id", id);
        if (spuDao.updateById(wxTabSpu) > 0) {
            if (skuDao.update(wxTabSku, queryWrapper) > 0) {
                return TenmallResult.ok();
            }
        }
        throw new ServiceException(MessageEnum.UPDATE_ERROR.getMessage());
    }

    @Override
    public TenmallResult pullReq(Long id) {
        WxTabSku wxTabSku = skuDao.selectById(id);
        wxTabSku.setStatus("2");
        if (skuDao.updateById(wxTabSku) > 0) {
            return TenmallResult.ok();
        }
        throw new ServiceException(MessageEnum.UPDATE_ERROR.getMessage());
    }

    @Override
    public TenmallResult shelvesReq(Long id) {
        WxTabSku wxTabSku = skuDao.selectById(id);
        WxTabSpu wxTabSpu = spuDao.selectById(wxTabSku.getSpuId());
        if (wxTabSpu.getStatus().equals(1)) {
            wxTabSku.setStatus("1");
            if (!wxTabSpu.getIsMarketable().equals("1")) {
                wxTabSpu.setIsMarketable("1");
                Integer integer = spuDao.updateById(wxTabSpu);
                if (integer < 0 || integer == 0) {
                    throw new ServiceException(MessageEnum.UPDATE_ERROR.getMessage());
                }
            }
            if (skuDao.updateById(wxTabSku) > 0) {
                return TenmallResult.ok();
            }

            throw new ServiceException(MessageEnum.UPDATE_ERROR.getMessage());
        }
        return TenmallResult.build(1, "商品未审核");
    }

    @Override
    public TenmallResult batchShelvesReq(Long[] id) {
        for (int i = 0; i < id.length; i++) {
            shelvesReq(id[i]);
        }
        return TenmallResult.ok();
    }

    @Override
    public TenmallResult batchPullReq(Long[] id) {
        for (int i = 0; i < id.length; i++) {
            pullReq(id[i]);
        }
        return TenmallResult.ok();
    }
}

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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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

import javax.swing.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

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

    private WxTabSku wxTabSku = new WxTabSku();
    private WxTabSpu wxTabSpu = new WxTabSpu();

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

    /**
     * 新增sku与spu
     *
     * @param map
     * @return
     */
    @Override
    public TenmallResult add(Map map) {
        List<Map> list = (List) map.get("skuList");
        Map map1 = JSONObject.parseObject(JSONObject.toJSONString(map.get("spu")), Map.class);
        boolean b = false;
        for (int i = 0; i < list.size(); i++) {

            Map map2 = JSONObject.parseObject(JSON.toJSONString(list.get(i)), Map.class);
            if (map2.get("spec")!=null){
                map2.put("spec","'"+map2.get("spec")+"'");
            }
            System.out.println(map2.get("spec"));
            try {
                int aa = skuDao.add(map2);
                if (aa > 0) {
                    b = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        if (b == true) {
            if (spuDao.add(map1) > 0) {
                return TenmallResult.success(MessageEnum.ADD_SUCCESS);
            } else {
                return TenmallResult.error(MessageEnum.ADD_ERROR);
            }
        }
        return TenmallResult.error(MessageEnum.ADD_ERROR);
    }
}

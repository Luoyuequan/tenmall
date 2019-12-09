package com.cn.tenmall.service.product;

import com.cn.tenmall.vo.TenmallResult;

import java.util.Map;

public interface ProductService {

    TenmallResult submitReq(Long id);

    TenmallResult findAuditALL(Integer status, Integer page, Integer size);

    TenmallResult auditReq(Long id);

    TenmallResult pullReq(Long id);

    TenmallResult shelvesReq(Long id);

    TenmallResult batchShelvesReq(Long[] id);

    TenmallResult batchPullReq(Long[] id);

    /**
     * 新增sku与spu
     *
     * @param map
     * @return
     */
    TenmallResult add(Map map);
}

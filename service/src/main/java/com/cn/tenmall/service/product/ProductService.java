package com.cn.tenmall.service.product;

import com.cn.tenmall.vo.TenmallResult;

public interface ProductService {

    TenmallResult submitReq(Long id);

    TenmallResult findAuditALL(Integer status, Integer page, Integer size);

    TenmallResult auditReq(Long id);

    TenmallResult pullReq(Long id);

    TenmallResult shelvesReq(Long id);

    TenmallResult batchShelvesReq(Long[] id);

    TenmallResult batchPullReq(Long[] id);
}

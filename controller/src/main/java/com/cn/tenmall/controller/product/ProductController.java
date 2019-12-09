/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ProductController
 * Author:   Administrator
 * Date:     2019/12/7 10:57
 * Description: 审核
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.tenmall.controller.product;

import com.cn.tenmall.service.product.ProductService;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈审核〉
 *
 * @author Administrator
 * @create 2019/12/7
 * @since 1.0.0
 */
@RestController
@RequestMapping("product")
public class ProductController {
    private ProductService productService;

    /**
     * 商品提交审核
     */
    @PostMapping("submitReq")
    public TenmallResult submitReq(@RequestParam Long id) {
        return productService.submitReq(id);
    }

    /**
     * 商品待审核商品列表
     */
    @PostMapping("findAuditALL")
    public TenmallResult findAuditALL(@RequestParam(defaultValue = "9") Integer status, @RequestParam Integer page, @RequestParam Integer size) {
        return productService.findAuditALL(status, page, size);
    }

    /**
     * 商品审核
     */
    @PostMapping("auditReq")
    public TenmallResult auditReq(@RequestParam Long id) {
        return productService.auditReq(id);
    }

    /**
     * 下架商品
     */
    @PostMapping("pullReq")
    public TenmallResult pullReq(@RequestParam Long id) {
        return productService.pullReq(id);
    }

    /**
     * 上架商品
     */
    @PostMapping("shelvesReq")
    public TenmallResult shelvesReq(@RequestParam Long id) {
        return productService.shelvesReq(id);
    }

    /**
     * 批量上架商品
     */
    @PostMapping("batchShelvesReq")
    public TenmallResult batchShelvesReq(@RequestParam Long... id) {
        return productService.batchShelvesReq(id);
    }

    /**
     * 批量下架商品
     */
    @PostMapping("batchPullReq")
    public TenmallResult batchPullReq(@RequestParam Long... id) {
        return productService.batchPullReq(id);
    }


    @Autowired
    ProductService service;
    @RequestMapping("add")
    public TenmallResult add(@RequestBody Map map) {

        return service.add(map);
    }
}

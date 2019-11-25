package com.cn.tenmall.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WxTabBrandDao {
    List<com.cn.tenmall.entity.WxTabBrand> finAll();
}

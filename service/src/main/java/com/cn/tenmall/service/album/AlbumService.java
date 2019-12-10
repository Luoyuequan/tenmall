package com.cn.tenmall.service.album;

import com.cn.tenmall.vo.TenmallResult;

import javax.servlet.http.HttpServletRequest;

public interface AlbumService {
    TenmallResult findAll();

    TenmallResult findById(Long id);

    TenmallResult delete(Long id);

    TenmallResult save(String title, HttpServletRequest request);

    TenmallResult modify(Long id, String title, HttpServletRequest request);
}

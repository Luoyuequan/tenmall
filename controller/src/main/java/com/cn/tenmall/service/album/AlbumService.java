package com.cn.tenmall.service.album;

import com.cn.tenmall.entity.WxTabAlbum;
import com.cn.tenmall.vo.TenmallResult;

public interface AlbumService {
    TenmallResult findAll();

    TenmallResult findById(Long id);

    TenmallResult save(WxTabAlbum album);

    TenmallResult modify(WxTabAlbum album);

    TenmallResult delete(Long id);
}

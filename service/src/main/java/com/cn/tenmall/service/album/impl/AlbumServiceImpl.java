/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: AlbumServiceImpl
 * Author:   Administrator
 * Date:     2019/12/7 10:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.tenmall.service.album.impl;

import com.cn.tenmall.dao.AlbumDao;
import com.cn.tenmall.entity.WxTabAlbum;
import com.cn.tenmall.enumClass.MessageEnum;
import com.cn.tenmall.service.album.AlbumService;
import com.cn.tenmall.service.exception.ServiceException;
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
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;
    @Override
    public TenmallResult findAll() {
        return TenmallResult.ok(albumDao.selectList(null));
    }

    @Override
    public TenmallResult findById(Long id) {
        return TenmallResult.ok(albumDao.selectById(id));
    }

    @Override
    public TenmallResult save(WxTabAlbum album) {
        if (albumDao.insert(album)>0){
            return  TenmallResult.ok();
        }
        throw new ServiceException(MessageEnum.ADD_ERROR.getMessage());
    }

    @Override
    public TenmallResult modify(WxTabAlbum album) {
        if (albumDao.updateById(album)>0){
            return  TenmallResult.ok();
        }
        throw new ServiceException(MessageEnum.UPDATE_ERROR.getMessage());
    }

    @Override
    public TenmallResult delete(Long id) {
        if (albumDao.deleteById(id)>0){
            return  TenmallResult.ok();
        }
        throw new ServiceException(MessageEnum.DELETE_ERROR.getMessage());
    }
}

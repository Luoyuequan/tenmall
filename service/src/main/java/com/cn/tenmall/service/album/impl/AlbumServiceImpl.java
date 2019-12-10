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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/12/7
 * @since 1.0.0
 */
@Service
@Slf4j
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
    public TenmallResult save(String title, HttpServletRequest request) {
        WxTabAlbum album=new WxTabAlbum();
        up(request,album,title);
        if (albumDao.insert(album)>0){
            return  TenmallResult.ok();
        }
        throw new ServiceException(MessageEnum.ADD_ERROR.getMessage());
    }

    @Override
    public TenmallResult modify(Long id, String title, HttpServletRequest request) {
        WxTabAlbum album=new WxTabAlbum();
        album.setId(id);
        up(request,album,title);
        if (albumDao.updateById(album)>0){
            return  TenmallResult.ok();
        }
        throw new ServiceException(MessageEnum.UPDATE_ERROR.getMessage());
    }

    @Override
    public TenmallResult delete(Long id) {
        if (albumDao.deleteById(id) > 0) {
            return TenmallResult.ok();
        }
        throw new ServiceException(MessageEnum.DELETE_ERROR.getMessage());
    }

    private void up(HttpServletRequest request,WxTabAlbum album,String title){
        album.setImage(upload(request));
        album.setImageItems(uploads(request));
        album.setTitle(title);
        if(album.getImage().equals("null")){
            throw new ServiceException(MessageEnum.FILE_ERROR.getMessage());
        }
        if(album.getImageItems().equals(">6")){
            throw new ServiceException(MessageEnum.FILE_ERROR.getMessage());
        }
    }
    private String upload(HttpServletRequest request) {
        MultipartFile file=((MultipartHttpServletRequest)request).getFile("image");
        try {
            if (file.isEmpty()) {
                return "null";
            }
            // 获取文件名
            String fileName = file.getOriginalFilename();
            log.info("上传的文件名为：" + fileName);
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            log.info("文件的后缀名为：" + suffixName);
            // 设置文件存储路径
            String filePath = request.getRealPath("upload/");
            String path = filePath + fileName;
            File dest = new File(path);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();// 新建文件夹
            }
            file.transferTo(dest);// 文件写入
            return path.substring(path.indexOf("upload"));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "null";
    }
    private String uploads(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("imageItems");
        if(files.size()>6){
            return ">6";
        }
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            String filePath = request.getRealPath("uploads/");
            if (!file.isEmpty()) {
                try {
                    String path=filePath + file.getOriginalFilename();
                    File dest = new File(path);
                    // 检测是否存在目录
                    if (!dest.getParentFile().exists()) {
                        dest.getParentFile().mkdirs();// 新建文件夹
                    }
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(dest));//设置文件路径及名字
                    stream.write(bytes);// 写入
                    stream.close();
                    sb.append(path.substring(path.lastIndexOf("uploads"))+";");
                } catch (Exception e) {
                    stream = null;
                    return "第 " + i + " 个文件上传失败 ==> "
                            + e.getMessage();
                }
            } else {
                return "第 " + i
                        + " 个文件上传失败因为文件为空";
            }
        }
        return sb.substring(0,sb.lastIndexOf(";"));
    }
}

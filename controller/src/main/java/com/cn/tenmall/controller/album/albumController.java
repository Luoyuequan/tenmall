/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: albumController
 * Author:   Albumistrator
 * Date:     2019/12/7 10:26
 * Description: 相册控制
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cn.tenmall.controller.album;

import com.cn.tenmall.entity.WxTabAlbum;
import com.cn.tenmall.service.album.AlbumService;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 〈一句话功能简述〉<br>
 * 〈相册控制〉
 *
 * @author Albumistrator
 * @create 2019/12/7
 * @since 1.0.0
 */
@RestController
@RequestMapping("photoes")
public class albumController {
    private AlbumService albumService;

    /**
     * 相册查询接口
     *
     * @return
     */
    @PostMapping("findAll")
    public TenmallResult findAll() {
        return albumService.findAll();
    }

    /**
     * 相册根据id接口
     *
     * @param id id
     * @return
     */
    @PostMapping("findById")
    public TenmallResult findById(@RequestParam Long id) {
        return albumService.findById(id);
    }

    /**
     * 相册新增接口
     *
     * @param album 相册对象
     * @return
     */
    @PostMapping("add")
    public TenmallResult add(@Valid WxTabAlbum album) {
        return albumService.save(album);
    }

    /**
     * 相册修改接口
     *
     * @param album 相册对象
     * @return
     */
    @PostMapping("update")
    public TenmallResult update(@Valid WxTabAlbum album) {
        return albumService.modify(album);
    }

    /**
     * 相册删除接口
     *
     * @param id id
     * @return
     */
    @PostMapping("delete")
    public TenmallResult delete(@RequestParam Long id) {
        return albumService.delete(id);
    }

}

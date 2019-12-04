package com.cn.tenmall.controller;

import com.cn.tenmall.entity.SepcEntity;
import com.cn.tenmall.service.SepcService;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sepc")
public class SepcController {
    @Autowired
    private SepcService sepcService;

    /**
     * 新增
     *
     * @param sepcEntity
     * @return
     */
    @RequestMapping("add")
    public TenmallResult add(SepcEntity sepcEntity) {
        if (isParam(sepcEntity)) {
            return TenmallResult.build(1, "参数不能为空");
        }
        return sepcService.add(sepcEntity);
    }

    /**
     * 修改
     *
     * @param sepcEntity
     * @return
     */
    @RequestMapping("update")
    public TenmallResult updateById(SepcEntity sepcEntity) {
        if (isParam(sepcEntity) || sepcEntity.getId() == null) {
            return TenmallResult.build(1, "参数不能为空");
        }
        return sepcService.updateById(sepcEntity);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public TenmallResult deleteById(Integer id) {
        if (id == null) {
            return TenmallResult.build(1, "参数不能为空");
        }
        return sepcService.deleteById(id);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @RequestMapping("findAll")
    public TenmallResult findAll() {
        return sepcService.findAll();
    }

    /**
     * 规格条件分页查询
     *
     * @param name
     * @param options
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("findCondPage")
    public TenmallResult findCondPage(String name, String options, Integer page, Integer size) {
        if (page == null || size == null) {
            return TenmallResult.build(1, "参数不能为空");
        }
        return sepcService.findCondPage(name, options, page, size);
    }


    /**
     * 判断参数是否为空
     *
     * @param sepcEntity
     * @return
     */
    public boolean isParam(SepcEntity sepcEntity) {
        if (sepcEntity == null || StringUtils.isEmpty(sepcEntity.getName())
                || StringUtils.isEmpty(sepcEntity.getOptions()) || sepcEntity.getSeq() == null || sepcEntity.getTemplateId() == null) {
            return true;
        }
        return false;
    }
}

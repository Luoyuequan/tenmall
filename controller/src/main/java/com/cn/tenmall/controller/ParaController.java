package com.cn.tenmall.controller;

import com.cn.tenmall.entity.ParaEntity;
import com.cn.tenmall.service.ParaService;
import com.cn.tenmall.vo.TenmallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("para")
public class ParaController {
    @Autowired
    private ParaService paraService;

    /**
     * 新增
     *
     * @param paraEntity
     * @return
     */
    @RequestMapping("add")
    public TenmallResult add(ParaEntity paraEntity) {
        if (isParam(paraEntity)) {
            return TenmallResult.build(1, "参数不能为空");
        }
        return paraService.add(paraEntity);
    }

    /**
     * 修改
     *
     * @param paraEntity
     * @return
     */
    @RequestMapping("update")
    public TenmallResult updateById(ParaEntity paraEntity) {
        if (isParam(paraEntity) || paraEntity.getId() == null) {
            return TenmallResult.build(1, "参数不能为空");
        }
        return paraService.updateById(paraEntity);
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
        return paraService.deleteById(id);
    }

    /**
     * 参数条件分页查询
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
        return paraService.findCondPage(name, options, page, size);
    }

    /**
     * 判断参数是否为空
     *
     * @param paraEntity
     * @return
     */
    public boolean isParam(ParaEntity paraEntity) {
        if (paraEntity == null || StringUtils.isEmpty(paraEntity.getName())
                || StringUtils.isEmpty(paraEntity.getOptions()) || paraEntity.getSeq() == null || paraEntity.getTemplateId() == null) {
            return true;
        }
        return false;
    }
}

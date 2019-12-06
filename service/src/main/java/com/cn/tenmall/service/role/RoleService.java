package com.cn.tenmall.service.role;

import com.cn.tenmall.entity.WxTabRole;
import com.cn.tenmall.vo.TenmallResult;

import java.io.Serializable;

public interface RoleService {
    /**
     * 新增角色业务
     * @param role
     * @return
     */
    TenmallResult save(WxTabRole role);

    /**
     * 修改角色业务
     * @param role
     * @return
     */
    TenmallResult modify(WxTabRole role);

    /**
     * 删除角色业务
     * @param id
     * @return
     */
    TenmallResult remove(Serializable id);

    /**
     * 查询角色列表
     * @return
     */
    TenmallResult findAll();
}

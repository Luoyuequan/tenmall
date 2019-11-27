package com.cn.tenmall.service.role;

import com.cn.tenmall.entity.WxTabRole;

import java.io.Serializable;
import java.util.List;

public interface RoleService {
    /**
     * 新增角色业务
     * @param role
     * @return
     */
    boolean save(WxTabRole role);

    /**
     * 修改角色业务
     * @param role
     * @return
     */
    boolean modify(WxTabRole role);

    /**
     * 删除角色业务
     * @param id
     * @return
     */
    boolean remove(Serializable id);

    /**
     * 查询角色列表
     * @return
     */
    List<WxTabRole> findAll();
}

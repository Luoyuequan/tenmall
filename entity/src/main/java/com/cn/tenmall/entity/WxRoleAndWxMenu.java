package com.cn.tenmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxRoleAndWxMenu {
    private long id;
    @NotNull
    @Min(1)
    private long roleId;
    @NotNull
    @Min(1)
    private long menuId;
}

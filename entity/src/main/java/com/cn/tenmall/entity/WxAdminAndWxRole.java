package com.cn.tenmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WxAdminAndWxRole {
    private long id;
    @NotNull
    @Min(1)
    private long adminId;
    @NotNull
    @Min(1)
    private long roleId;
}

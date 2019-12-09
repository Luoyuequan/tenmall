package com.cn.tenmall.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxTabAdmin {
    private long id;
    @NotNull
    private String loginName;
    @JsonView(adminDeta.class)
    @NotNull
    private String password;
    private long status;

    public interface adminSim {
    }

    public interface adminDeta extends adminSim {
    }
}

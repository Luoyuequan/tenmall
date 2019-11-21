package com.cn.tenmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author Administrator
 */
@EnableConfigurationProperties
@SpringBootApplication
public class TenMallApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TenMallApplication.class);
//        禁用命令行更改配置文件属性
//        springApplication.setAddCommandLineProperties(false);
        springApplication.run(args);
    }

}

package com.cn.tenmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Administrator
 */
@EnableConfigurationProperties
@SpringBootApplication
@MapperScan("com.cn.tenmall.dao")
@EnableSwagger2
@EnableTransactionManagement//开启事务
public class TenMallApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TenMallApplication.class);
//        禁用命令行更改配置文件属性
//        springApplication.setAddCommandLineProperties(false);
        springApplication.run(args);
    }
}

package com.chongyou.webapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication(scanBasePackages="com.champion.controller")
@MapperScan("com.champion.mapper")
@ComponentScan("com.champion")
public class WebapplicationApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebapplicationApplication.class, args);
    }

}

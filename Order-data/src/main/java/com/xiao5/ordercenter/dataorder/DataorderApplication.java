package com.xiao5.ordercenter.dataorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiao5.ordercenter.dataorder.mapper")
public class DataorderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataorderApplication.class, args);
    }

}

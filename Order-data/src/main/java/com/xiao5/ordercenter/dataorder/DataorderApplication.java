package com.xiao5.ordercenter.dataorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.xiao5.ordercenter.dataorder.mapper")
@EnableTransactionManagement
public class DataorderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataorderApplication.class, args);
    }

}

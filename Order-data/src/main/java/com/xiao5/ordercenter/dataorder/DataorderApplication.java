package com.xiao5.ordercenter.dataorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.xiao5.ordercenter.dataorder.repository"})
@MapperScan("com.xiao5.ordercenter.dataorder.mapper")
@EntityScan("com.xiao5.ordercenter.common.entity")
@EnableTransactionManagement
@EnableEurekaClient
public class DataorderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataorderApplication.class, args);
    }

}

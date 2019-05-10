package com.xiao5.ordercenter.dataorder.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ：tianyda$
 * @date ：Created in 2019/5/10 9:26
 * @description：MyBaits配置类
 * @modified By：
 * @version: 1.0.0$
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.xiao5.ordercenter.dataorder.dao")
public class MyBatisConfig {
}

package com.xiao5.ordercenter.service.test;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author Wu Tianbing
 * @version V1.0
 * @Description:
 * @className: Demos
 * @date 2020/8/7/007 14:48
 * @company:西安博达软件股份有限公司
 * @copyright: Copyright (c) 2020
 */
public class Demos {


    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://id.hqu.edu.cn/authserver/serviceValidate?ticket=ST-373439-cPVF4eWgzmupH10fKt0Q1598860136292-Fyip-cas&service=http://openapp.vsbclub.com/wechat-hqu/casLogin.html";
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, null, String.class, new Object());

        System.out.println(exchange.getBody());




    }



}

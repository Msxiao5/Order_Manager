package com.xiao5.ordercenter.dataorder.controller;

import com.xiao5.ordercenter.dataorder.service.OrderentryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：mmzs
 * @date ：Created in 2019/4/18 14:58
 * @description：OrderentriesController
 * @modified By：
 * @version: 1.0.0$
 */
@Slf4j
@RestController
@RequestMapping("/orderentry")
public class OrderentriesController {
    @Resource
    OrderentryService orderentryService;

}

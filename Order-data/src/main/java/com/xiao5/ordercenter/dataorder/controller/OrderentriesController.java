package com.xiao5.ordercenter.dataorder.controller;

import com.xiao5.ordercenter.common.entity.order.Orderentries;
import com.xiao5.ordercenter.dataorder.service.OrderentryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：订单信息controller
 * @date ：Created in 2019/4/18 14:58
 * @version: 1.0.0$
 */
@Slf4j
@RestController
@RequestMapping("/orderentry")
public class OrderentriesController {
    @Autowired
    OrderentryService orderentryService;

    /**
     *  根据订单ID获取订单信息
     * @author Wu TianBing
     * @date 2019/4/18 22:26
     * @param orderentryid	订单ID
     * @return com.xiao5.ordercenter.dataorder.entity.Orderentries
     */
    @GetMapping("/get/{id}")
    public Orderentries get(@PathVariable("id") String orderentryid){
        //调用开始时间
        long startTimeMillis = System.currentTimeMillis();
        Orderentries orderentries = orderentryService.findByOderentryid(orderentryid);
        if (orderentries == null){
            log.info("【当前订单编号：{}，无对应订单信息】",orderentryid);
        }
        //耗时
        long timeConsuming = System.currentTimeMillis() - startTimeMillis;
        log.info("【时长:{}毫秒】", timeConsuming);
        return orderentries;
    }

    /**
     * 根据客户编码，获取订单信息集合
     * @author Wu TianBing
     * @date 2019/4/18 22:26
     * @param orderentries orderentryid, custmoercode, custmoername	查询条件
     * @return java.util.List<com.xiao5.ordercenter.dataorder.entity.Orderentries>
     */
    @GetMapping("/getlist")
    public List<Orderentries> getList(@PathVariable("orderentries") Orderentries orderentries ){
        long startTimeMillis = System.currentTimeMillis();
        List<Orderentries> result = orderentryService.selectOrderListByCondition(orderentries);
        if (CollectionUtils.isEmpty(result)){
            log.info("【当前客户编码：{}，无对应订单信息】",orderentries);
        }
        //耗时
        long timeConsuming = System.currentTimeMillis() - startTimeMillis;
        log.info("【时长:{}毫秒】", timeConsuming);
        return result;
    }

    /**
     *  获取所有订单信息
     * @author Wu TianBing
     * @date 2019/4/18 22:27
     * @param
     * @return java.util.List<com.xiao5.ordercenter.dataorder.entity.Orderentries>
     */
    @GetMapping("/getAll")
    public List<Orderentries> getAll(){
        long startTimeMillis = System.currentTimeMillis();
        List<Orderentries> orderentries = orderentryService.findAll();
        if (CollectionUtils.isEmpty(orderentries)){
            log.info("【当前无对应订单信息】");
        }
        //耗时
        long timeConsuming = System.currentTimeMillis() - startTimeMillis;
        log.info("【时长:{}毫秒】", timeConsuming);
        return orderentries;
    }

    /**
     *  保存插入订单数据
     * @author Wu TianBing
     * @date 2019/4/18 22:27
     * @param orderentries	订单数据对象
     * @return java.lang.String
     */
    @PostMapping("/save")
    public Integer save(@RequestBody Orderentries orderentries){
        long startTimeMillis = System.currentTimeMillis();

        Integer integer = orderentryService.AddOrderentry(orderentries);
        if (integer == 0){
            log.info("【保存订单信息失败】");
        }
        //耗时
        long timeConsuming = System.currentTimeMillis() - startTimeMillis;
        log.info("【时长:{}毫秒】", timeConsuming);
        return integer;

    }
}

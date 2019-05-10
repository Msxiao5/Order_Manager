package com.xiao5.ordercenter.dataorder.controller;

import com.xiao5.ordercenter.common.entity.order.Orderentries;
import com.xiao5.ordercenter.dataorder.dto.OrderQueryParam;
import com.xiao5.ordercenter.dataorder.service.OrderentryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "OrderentriesController",description = "订单管理")
@RequestMapping("/order")
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
    @GetMapping("/getdetail/{id}")
    public Orderentries get(@PathVariable("id") String orderentryid){
        //调用开始时间
        long startTimeMillis = System.currentTimeMillis();
        Orderentries orderentries = orderentryService.getdetail(orderentryid);
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
/*
    @GetMapping("/getlist/{orderentries}")
 public List<Orderentries> getList(@PathVariable("orderentries") Orderentries orderentries  ){
        long startTimeMillis = System.currentTimeMillis();
        List<Orderentries> orderResult = orderentryService.selectOrderListByCondition(orderentries);
        if (CollectionUtils.isEmpty(orderResult)){
            log.info("【当前客户编码：{}，无对应订单信息】",orderentries);
        }
        //耗时
        long timeConsuming = System.currentTimeMillis() - startTimeMillis;
        log.info("【时长:{}毫秒】", timeConsuming);
        return orderResult;
    }
*/

    /**
     *  条件查询订单
     * @author Wu TianBing
     * @date 2019/4/18 22:27
     * @param
     * @return java.util.List<com.xiao5.ordercenter.dataorder.entity.Orderentries>
     */
    @ApiOperation(value = "查询订单")
    @GetMapping(value = "/orderlist")
    @ResponseBody
    public List<Orderentries> list(OrderQueryParam queryParam,@RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum ){
        long startTimeMillis = System.currentTimeMillis();
        List<Orderentries> orderList = orderentryService.list(queryParam,pageSize,pageSize);
        if (CollectionUtils.isEmpty(orderList)){
            log.info("【当前无对应订单信息】");
        }
        //耗时
        long timeConsuming = System.currentTimeMillis() - startTimeMillis;
        log.info("【时长:{}毫秒】", timeConsuming);
        return orderList;
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
    /**
     *  保存插入订单数据
     * @author tianyda
     * @date 2019/4/18 22:27
     * @param orderentryids
     * @return java.lang.Interger
     */
    public Integer delete(List<String> orderentryids){
        long startTimeMillis = System.currentTimeMillis();
        Integer count = orderentryService.delete(orderentryids);
        if (count == 0){
            log.info("【删除订单失败】");
        }
        //耗时
        long timeConsuming = System.currentTimeMillis() - startTimeMillis;
        log.info("【时长：{}毫秒】",timeConsuming);
        return count;
    }
}

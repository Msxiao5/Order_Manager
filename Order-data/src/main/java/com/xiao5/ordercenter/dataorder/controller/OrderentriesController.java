package com.xiao5.ordercenter.dataorder.controller;

import com.xiao5.ordercenter.dataorder.entity.Orderentries;
import com.xiao5.ordercenter.dataorder.service.OrderentryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/queryOrderByorderentryid/{orderentryid}")
    public Orderentries queryOrderByorderentryid (@PathVariable("orderentryid") String orderentryid){
        //调用开始时间
        long startTimeMillis = System.currentTimeMillis();
        Orderentries orderentries = orderentryService.queryOrderByorderentryid(orderentryid);
        if (orderentries == null){
            log.info("【当前{}orderentryid，无对应订单信息】",orderentryid);
        }
        //耗时
        long timeConsuming = System.currentTimeMillis() - startTimeMillis;
        log.info("【时长:{}毫秒】", timeConsuming);
        return orderentries;
    }
    @GetMapping("/showOrderList")
    public Object showOrderListbycutcd(String customercode){
        return orderentryService.showOrderListbycutcd(customercode);
    }
    @GetMapping("/showOrderList")
    public Object showOrderList(){
        return orderentryService.showOrderList();
    }
    @PostMapping("/Addorder")
    public String AddOrderentry(String customercode, String customername, String custtyp,
                                String merchandisecode, String merchandisename, String merchandisetype,
                                String mdseshare, String accno, String currency, String netamount,
                                String mdsecount, String mediatype, String authmethod, String devicecode,
                                String channelcode, String channelserialno, String ordersdate, String orderstime,
                                String remark){
        long currenttime = System.currentTimeMillis();
        int randomdata = (int)(1+Math.random()*100000);
        String orderentryid = String.valueOf(currenttime) + String.valueOf(randomdata);
        String crtdatetime = String.valueOf(currenttime).substring(0,13);
        return orderentryService.AddOrderentry(orderentryid,customercode,customername,custtyp,merchandisecode,merchandisename,merchandisetype,mdseshare,accno,currency,netamount,mdsecount,mediatype,authmethod,devicecode,channelcode,channelserialno,ordersdate,orderstime,crtdatetime,remark);

    }
}

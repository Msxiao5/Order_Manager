package com.xiao5.ordercenter.dataorder.service;

import com.xiao5.ordercenter.dataorder.mapper.OrderentryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xiao5.ordercenter.dataorder.entity.Orderentries;

import javax.annotation.Resource;

/**
 * @author ：mmzs
 * @date ：Created in 2019/4/18 12:01
 * @description：订单业务层
 * @modified By：
 * @version: 1.0.0$
 */
@Service
@Slf4j
public class OrderentryService {
    @Resource
    OrderentryMapper orderentryMapper;
    public Orderentries queryOrderByorderentryid(String orderentryid) {
        log.info("【根据订单号查询订单详细信息】", orderentryid);
        Orderentries orderentries = orderentryMapper.queryOrderByorderentryid(orderentryid);
        log.info("当前订单号orderentryid = {},查询结果为:{}",orderentryid,orderentries.toString());
        return orderentries;
    }
}

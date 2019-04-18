package com.xiao5.ordercenter.dataorder.service;

import com.xiao5.ordercenter.dataorder.mapper.OrderentryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import com.xiao5.ordercenter.dataorder.entity.Orderentries;

import javax.annotation.Resource;
import java.util.List;

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

    /**
     *  根据订单号查询订单信息
     * @author Wu TianBing
     * @date 2019/4/18 22:36
     * @param orderentryid	订单编号
     * @return com.xiao5.ordercenter.dataorder.entity.Orderentries
     */
    public Orderentries queryOrderByorderentryid(String orderentryid) {
        log.info("【根据订单号查询订单详细信息】", orderentryid);
        Orderentries orderentries = orderentryMapper.queryOrderByorderentryid(orderentryid);
        log.info("当前订单号orderentryid = {},查询结果为:{}", orderentryid, orderentries.toString());
        return orderentries;
    }

    /**
     *  根据客户号查询订单列表
     * @author Wu TianBing
     * @date 2019/4/18 22:35
     * @param customercode	客户编码
     * @return java.util.List<com.xiao5.ordercenter.dataorder.entity.Orderentries>
     */
    public List<Orderentries> showOrderListbycutcd(String customercode) {
        log.info("【根据客户号查询订单列表】", customercode);
        return orderentryMapper.getOrderListbycutcd(customercode);
    }

    /**
     *  初始化查询订单列表
     * @author Wu TianBing
     * @date 2019/4/18 22:35
     * @param
     * @return java.util.List<com.xiao5.ordercenter.dataorder.entity.Orderentries>
     */
    public List<Orderentries> showOrderList() {
        return orderentryMapper.getOrderList();
    }

    /**
     *  录入一条订单
     * @author Wu TianBing
     * @date 2019/4/18 22:35
     * @param orderentries	订单信息对象
     * @return java.lang.Integer
     */
    public Integer AddOrderentry(Orderentries orderentries) {
        int count = 0;
        try {
            orderentryMapper.AddOrderentry(orderentries);
            count++;
            return count;
        }catch (Exception e){
            return 0;
        }

    }
}

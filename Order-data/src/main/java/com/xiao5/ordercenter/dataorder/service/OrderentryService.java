package com.xiao5.ordercenter.dataorder.service;

import com.xiao5.ordercenter.common.entity.order.Orderentries;
import com.xiao5.ordercenter.common.utils.DateUtils;
import com.xiao5.ordercenter.common.utils.OrderCodeFactory;
import com.xiao5.ordercenter.dataorder.mapper.OrderentryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 根据订单号查询订单信息
     *
     * @param orderentryid 订单编号
     * @return com.xiao5.ordercenter.dataorder.entity.Orderentries
     * @author Wu TianBing
     * @date 2019/4/18 22:36
     */
    public Orderentries findByOderentryid(String orderentryid) {
        log.info("【根据订单号查询订单详细信息】", orderentryid);
        Orderentries orderentries = orderentryMapper.findByOderentryid(orderentryid);
        log.info("当前订单号orderentryid = {},查询结果为:{}", orderentryid, orderentries.toString());
        return orderentries;
    }

    /**
     * 根据条件查询订单列表
     *
     * @param  conditionMap
     * @return java.util.List<com.xiao5.ordercenter.dataorder.entity.Orderentries>
     * @author Wu TianBing
     * @date 2019/4/18 22:35
     */
    public List<Orderentries> selectOrderListByCondition(Map<String,String> conditionMap) {

        log.info("【根据条件查询订单列表】", conditionMap);
        return orderentryMapper.selectOrderListByCondition(conditionMap);
    }

    /**
     * 初始化查询订单列表
     *
     * @param
     * @return java.util.List<com.xiao5.ordercenter.dataorder.entity.Orderentries>
     * @author Wu TianBing
     * @date 2019/4/18 22:35
     */
    public List<Orderentries> findAll() {
        return orderentryMapper.findAll();
    }

    /**
     * 录入一条订单
     *
     * @param orderentries 订单信息对象
     * @return java.lang.Integer
     * @author Wu TianBing
     * @date 2019/4/18 22:35
     */
    public Integer AddOrderentry(Orderentries orderentries) {
        String orderentryid = OrderCodeFactory.getOrderCodeByAtomic();
        String crtdatetime = DateUtils.getYYYYMMDDHHMMSS(new Date());
        int count = 0;
        try {
            orderentries.setOrderentryid(orderentryid).setCrtdatetime(crtdatetime);
            orderentryMapper.AddOrderentry(orderentries);

            count++;
            return count;
        } catch (Exception e) {
            return 0;
        }

    }
}

package com.xiao5.ordercenter.dataorder.service;

import com.xiao5.ordercenter.common.entity.order.Orderentries;
import com.xiao5.ordercenter.common.utils.DateUtils;
import com.xiao5.ordercenter.common.utils.OrderCodeFactory;
import com.xiao5.ordercenter.dataorder.mapper.OrderentryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
    public Orderentries findByOderentryid(String orderentryid) {
        log.info("【根据订单号查询订单详细信息】", orderentryid);
        Orderentries orderentries = orderentryMapper.findByOderentryid(orderentryid);
        log.info("当前订单号orderentryid = {},查询结果为:{}", orderentryid, orderentries.toString());
        return orderentries;
    }

    /**
     *  根据条件查询订单列表
     * @author Wu TianBing
     * @date 2019/4/18 22:35
     * @param condition	查询条件，条件包含custmoercode，custmoername,custmoercode and custmoername,"",由web端传参决定
     * @return java.util.List<com.xiao5.ordercenter.dataorder.entity.Orderentries>
     */
    public List<Orderentries> selectOrderListByCondition(String condition) {
        log.info("【根据条件查询订单列表】", condition);
        return orderentryMapper.selectOrderListByCondition(condition);
    }

    /**
     *  初始化查询订单列表
     * @author Wu TianBing
     * @date 2019/4/18 22:35
     * @param
     * @return java.util.List<com.xiao5.ordercenter.dataorder.entity.Orderentries>
     */
    public List<Orderentries> fiadAll() {
        return orderentryMapper.findAll();
    }

    /**
     *  录入一条订单
     * @author Wu TianBing
     * @date 2019/4/18 22:35
     * @param orderentries	订单信息对象
     * @return java.lang.Integer
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
        }catch (Exception e){
            return 0;
        }

    }
}

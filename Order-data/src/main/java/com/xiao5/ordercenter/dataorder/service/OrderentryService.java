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
    //根据订单号查询订单信息
    public Orderentries queryOrderByorderentryid(String orderentryid) {
        log.info("【根据订单号查询订单详细信息】", orderentryid);
        Orderentries orderentries = orderentryMapper.queryOrderByorderentryid(orderentryid);
        log.info("当前订单号orderentryid = {},查询结果为:{}", orderentryid, orderentries.toString());
        return orderentries;
    }
    //根据客户号查询订单列表
    public List<Orderentries> showOrderListbycutcd(String customercode) {
        log.info("【根据客户号查询订单列表】", customercode);
        return orderentryMapper.getOrderListbycutcd(customercode);
    }
    //初始化查询订单列表
    public List<Orderentries> showOrderList() {
        return orderentryMapper.getOrderList();
    }
    //录入一条订单
    public String AddOrderentry(String orderentryid, String customercode, String customername, String custtyp,
                                String merchandisecode, String merchandisename, String merchandisetype,
                                String mdseshare, String accno, String currency, String netamount,
                                String mdsecount, String mediatype, String authmethod, String devicecode,
                                String channelcode, String channelserialno, String ordersdate, String orderstime,
                                String crtdatetime, String remark) {
        Orderentries orderentries = new Orderentries();
        orderentries.setOrderentryid(orderentryid);
        orderentries.setCustomercode(customercode);
        orderentries.setCustomername(customername);
        orderentries.setCusttyp(custtyp);
        orderentries.setMerchandisecode(merchandisecode);
        orderentries.setMerchandisename(merchandisename);
        orderentries.setMerchandisetype(merchandisetype);
        orderentries.setMdseshare(mdseshare);
        orderentries.setAccno(accno);
        orderentries.setCurrency(currency);
        orderentries.setNetamount(netamount);
        orderentries.setMdsecount(mdsecount);
        orderentries.setMediatype(mediatype);
        orderentries.setAuthmethod(authmethod);
        orderentries.setDevicecode(devicecode);
        orderentries.setChannelcode(channelcode);
        orderentries.setChannelserialno(channelserialno);
        orderentries.setOrdersdate(ordersdate);
        orderentries.setOrderstime(orderstime);
        orderentries.setCrtdatetime(crtdatetime);
        orderentries.setRemark(remark);
        return "订单录入ok!";
    }
}

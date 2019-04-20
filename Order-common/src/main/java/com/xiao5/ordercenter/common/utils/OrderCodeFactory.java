package com.xiao5.ordercenter.common.utils;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author ：tianyda
 * @date ：Created in 2019-04-20 16:42
 * @description：订单号生成器
 * @modified By：
 * @version: 1.0.0$
 */
public class OrderCodeFactory {
    //订单类别头
    private static final String   ORDER_CODE = "1";
    private static final AtomicInteger atomicInteger = new AtomicInteger(10000000);

/***
 * @author tianyda
 * 获取同一秒中生成订单号连续
 * @return 返回同一秒钟生成的订单号连续
 */

    public static synchronized  String getOrderCodeByAtomic(){
        String currentTime = DateUtils.getYYYYMMDDHHMMSS(new Date());
        atomicInteger.getAndIncrement();
        int i = atomicInteger.get();
        return ORDER_CODE + currentTime + String.valueOf(i);
    }
}

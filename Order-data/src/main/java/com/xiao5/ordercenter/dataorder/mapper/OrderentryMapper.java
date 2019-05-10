package com.xiao5.ordercenter.dataorder.mapper;

import com.xiao5.ordercenter.common.entity.order.Orderentries;
import com.xiao5.ordercenter.dataorder.dto.OrderQueryParam;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author ：mmzs
 * @date ：Created in 2019/4/18 11:59
 * @description：订单路由Mapper
 * @modified By：
 * @version: 1.0.0$
 */
@Mapper
public interface OrderentryMapper {
    /**
     * 条件查询
     * @param queryParam
     * @return
     */
    List<Orderentries> getList(@Param("queryParam")OrderQueryParam queryParam,Integer pageSize,Integer pageNum);
    /**
     * 根据订单编号查询订单信息
     */
    Orderentries getOrderDetail(String orderentryid);

    /**
     * 生成订单
     * @param orderentries
     * @return java.lang.Interger
     */
    int AddOrderentry(Orderentries orderentries);

    /**
     * 批量删除订单
     * @param orderentryid
     * @return java.lang.Interger
     */
    @Transactional
    int delOrder(String orderentryid);

}

package com.xiao5.ordercenter.dataorder.mapper;

import com.xiao5.ordercenter.common.entity.order.Orderentries;
import org.apache.ibatis.annotations.*;

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
    @Results({
            @Result(property = "orderentryid", column = "orderentryid"),
            @Result(property = "customercode", column = "customercode"),
            @Result(property = "customername", column = "customername"),
            @Result(property = "custtyp", column = "custtyp"),
            @Result(property = "merchandisecode", column = "merchandisecode"),
            @Result(property = "merchandisename", column = "merchandisename"),
            @Result(property = "merchandisetype", column = "merchandisetype"),
            @Result(property = "mdseshare", column = "mdseshare"),
            @Result(property = "accno", column = "accno"),
            @Result(property = "currency", column = "currency"),
            @Result(property = "netamount", column = "netamount"),
            @Result(property = "mdsecount", column = "mdsecount"),
            @Result(property = "mediatype", column = "mediatype"),
            @Result(property = "authmethod", column = "authmethod"),
            @Result(property = "devicecode", column = "devicecode"),
            @Result(property = "channelcode", column = "channelcode"),
            @Result(property = "channelserialno", column = "channelserialno"),
            @Result(property = "ordersdate", column = "ordersdate"),
            @Result(property = "orderstime", column = "orderstime"),
            @Result(property = "crtdatetime", column = "crtdatetime"),
            @Result(property = "remark", column = "remark")

    })
    Orderentries findByOderentryid(String orderentryid);

    List<Orderentries> findAll();

    List<Orderentries> selectOrderListByCondition(Orderentries orderentries);

    int AddOrderentry(Orderentries orderentries);

}

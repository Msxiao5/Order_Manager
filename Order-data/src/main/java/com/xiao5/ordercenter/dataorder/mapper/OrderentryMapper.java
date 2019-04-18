package com.xiao5.ordercenter.dataorder.mapper;

import com.xiao5.ordercenter.dataorder.entity.Orderentries;
import com.xiao5.ordercenter.dataorder.service.OrderentryService;
import org.apache.ibatis.annotations.*;

import java.util.List;

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
    @Select(value = "Select * from ORDERENTRY where orderentryid = #{orderentryid}")
    Orderentries queryOrderByorderentryid(String orderentryid);

    @Select(value = "Select * from ORDERENTRY")
    List<Orderentries> getOrderList();

    @Select(value = "Select * from ORDERENTRY where customercode = #{customercode}")
    List<Orderentries> getOrderListbycutcd(String customercode);

    @Insert("insert into ORDERENTRY (orderentryid,customercode,customername,custtyp,merchandisecode,merchandisename," +
            "merchandisetype,mdseshare,accno,currency,netamount,mdsecount,mediatype,authmethod,devicecode,channelcode," +
            "channelserialno,ordersdate,orderstime,crtdatetime,remark) values (#{orderentryid},#{customercode}," +
            "#{customername},#{custtyp},#{merchandisecode},#{merchandisename},#{merchandisetype},#{mdseshare}," +
            "#{accno},#{currency},#{netamount},#{mdsecount},#{mediatype},#{authmethod},#{devicecode},#{channelcode}," +
            "#{channelserialno},#{ordersdate},#{orderstime},#{crtdatetime},#{remark})")
    void AddOrderentry(Orderentries orderentries);

}

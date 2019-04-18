package com.xiao5.ordercenter.dataorder.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author ：tianyda
 * @date ：Created in 2019/4/18 11:45
 * @description：订单信息录入
 * @modified By：
 * @version: 1.0.0$
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "订单录入数据实体")
@Table(name = "ORDERENTRY")
@Accessors(chain = true)
public class Orderentries implements Serializable {
    @Column(name = "orderentryid")
    private  String orderentryid;
    @Column (name = "customercode")
    private String customercode;
    @Column (name = "customername")
    private String customername;
    @Column (name = "custtyp")
    private String custtyp;
    @Column (name = "merchandisecode")
    private String merchandisecode;
    @Column (name = "merchandisename")
    private String merchandisename;
    @Column (name = "merchandisetype")
    private String merchandisetype;
    @Column (name = "mdseshare")
    private String mdseshare;
    @Column (name = "accno")
    private String accno;
    @Column (name = "currency")
    private String currency;
    @Column (name = "netamount")
    private String netamount;
    @Column (name = "mdsecount")
    private String mdsecount;
    @Column (name = "mediatype")
    private String mediatype;
    @Column (name = "authmethod")
    private String authmethod;
    @Column (name = "devicecode")
    private String devicecode;
    @Column (name = "channelcode")
    private String channelcode;
    @Column (name = "channelserialno")
    private String channelserialno;
    @Column (name = "ordersdate")
    private String ordersdate;
    @Column (name = "orderstime")
    private String orderstime;
    @Column (name = "crtdatetime")
    private String crtdatetime;
    @Column (name = "remark")
    private String remark;

}

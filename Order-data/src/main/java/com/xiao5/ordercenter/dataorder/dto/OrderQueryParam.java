package com.xiao5.ordercenter.dataorder.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ：tianyda$
 * @date ：Created in 2019/5/10 10:25
 * @description：订单查询参数
 * @modified By：
 * @version: 1.0.0$
 */
@Getter
@Setter
public class OrderQueryParam {
    @ApiModelProperty(value = "客户编号")
    private String customercode ;
    @ApiModelProperty(value = "客户名称")
    private String customername;
    @ApiModelProperty(value = "订单编号")
    private String orderentryid;
    @ApiModelProperty(value = "下单起始日期")
    private String ordersstdate;
    @ApiModelProperty(value = "下单终止日期")
    private String ordersenddate;
    @ApiModelProperty(value = "下单日期")
    private String ordersdate;

}

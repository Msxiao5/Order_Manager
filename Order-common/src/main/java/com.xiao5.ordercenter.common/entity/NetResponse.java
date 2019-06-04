package com.xiao5.ordercenter.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @auther: Wu Tianbing
 * @date: 2019/5/29/029 16:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NetResponse<T> implements Serializable {

    /**
     * 响应码
     */
    public String code = "0000" ;

    /**
     * 响应消息
     */
    public String massage = "成功";

    /**
     * 公共响应体
     */
    public T result;

}

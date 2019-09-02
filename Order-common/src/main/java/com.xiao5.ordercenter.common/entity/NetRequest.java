package com.xiao5.ordercenter.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Administrator
 * @auther: Wu Tianbing
 * @date: 2019/5/29/029 16:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NetRequest<T> implements Serializable {

    /**
     * 公共响应体
     */
    public T request;

}

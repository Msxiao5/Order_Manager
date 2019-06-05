package com.xiao5.ordercenter.common.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @auther: Wu Tianbing
 * @date: 2019/6/5/005 13:57
 */
@Data
@Entity
public class Syslogs implements Serializable {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 类型
     */
    private String type;

    /**
     * 请求人
     */
    private String createBy;

    /**
     * 时间
     */
    private Date createDate;

    /**
     * 请求地址
     */
    private String remoteAddr;

    /**
     * 浏览器
     */
    private String userAgent;

    /**
     * 请求URL
     */
    private String requestUri;

    /**
     * 调用方法
     */
    private String method;

    /**
     * 用户名
     */
    private String username;

    /**
     * 请求参数
     */
    private String params;

    /**
     * 内容
     */
    private String content;

}

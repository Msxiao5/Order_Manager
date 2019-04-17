package com.xiao5.ordercenter.dataorder.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 用户实体类
 * @author WuTian Bing
 * @version 1.0
 * @classname Users
 * @date 2019/3/20 16:01
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "用户实体")
@Table(name = "USERS")
@Accessors(chain = true)
public class Users implements Serializable{

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "passWord")
    private String passWord;

    @Column(name = "age")
    private String age;

    @Column(name = "remark")
    private String remark;

    @Column(name = "status")
    private String status;

}

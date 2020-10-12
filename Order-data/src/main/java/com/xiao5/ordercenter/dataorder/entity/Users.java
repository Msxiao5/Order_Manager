package com.xiao5.ordercenter.dataorder.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户实体类
 * @author WuTian Bing
 * @version 1.0
 * @classname Users
 * @date 2019/3/20 16:01
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "USERS")
@Entity
public class Users implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private String age;

    @Column(name = "remark")
    private String remark;

    @Column(name = "status")
    private String status;

}

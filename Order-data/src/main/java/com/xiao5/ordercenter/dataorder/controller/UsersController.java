package com.xiao5.ordercenter.dataorder.controller;

import com.xiao5.ordercenter.dataorder.entity.Users;
import com.xiao5.ordercenter.dataorder.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户controller
 * @author WuTian Bing
 * @version 1.0
 * @classname UsersController
 * @date 2019/3/21 16:44
 **/
@Slf4j
@RestController
@RequestMapping("/user")
public class UsersController {

    @Resource
    UsersService usersService;

    /**
     * 根据用户Id查询用户信息
     * @author Wu TianBing
     * @date 2019/3/21 17:12
     * @param  id 用户Id
     * @return com.xiao5.ordercenter.dataorder.entity.Users
     */
    @GetMapping("/qryUsersById/{id}")
    public Users qryUsersById(@PathVariable("id") Long id){
        //调用开始时间
        long startTimeMillis = System.currentTimeMillis();

        Users users = usersService.qryUsersById(id);
        if (null == users){
            log.info("【当前{}ID，无对应用户】",id);
        }
        //耗时
        long timeConsuming = System.currentTimeMillis() - startTimeMillis;
        log.info("【时长:{}毫秒】", timeConsuming);
        return users;
    }
}

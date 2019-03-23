package com.xiao5.ordercenter.dataorder.service;

import com.xiao5.ordercenter.dataorder.entity.Users;
import com.xiao5.ordercenter.dataorder.mapper.UsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务层
 * @author WuTian Bing
 * @version 1.0
 * @date 2019/3/21 16:45
 **/
@Slf4j
@Service
public class UsersService {

    @Autowired
    UsersMapper usersMapper;

    /**
     * 根据用户Id查询用户信息
     * @author Wu TianBing
     * @date 2019/3/21 17:12
     * @param  id 用户Id
     * @return com.xiao5.ordercenter.dataorder.entity.Users
     */
    public Users qryUsersById(Long id) {
        log.info("【根据Id查询当前用户，当前Id={}】",id);
        Users users = usersMapper.qryUsersById(id);
        log.info("【当前Id = {},查询用户结果为：{}】",id ,users.toString());
        return users;
    }
}
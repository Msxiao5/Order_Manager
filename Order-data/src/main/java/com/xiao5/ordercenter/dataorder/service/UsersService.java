package com.xiao5.ordercenter.dataorder.service;

import com.xiao5.ordercenter.dataorder.entity.Users;
import com.xiao5.ordercenter.dataorder.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务层
 * @author WuTian Bing
 * @version 1.0
 * @date 2019/3/21 16:45
 **/
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
        return usersMapper.qryUsersById(id);
    }
}

package com.xiao5.ordercenter.dataorder.service;

import com.xiao5.ordercenter.common.entity.user.Users;

public interface IUsersService {

    /**
     * 根据用户Id查询用户信息
     * @author Wu TianBing
     * @date 2019/3/21 17:12
     * @param  id 用户Id
     * @return com.xiao5.ordercenter.common.entity.user.Users
     */
    Users qryUsersById(Integer id);


}

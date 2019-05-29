package com.xiao5.ordercenter.dataorder.service;

import com.xiao5.ordercenter.common.entity.NetResponse;
import com.xiao5.ordercenter.common.entity.user.Users;

public interface IUsersService {

    /**
     * 根据用户Id查询用户信息
     * @author Wu TianBing
     * @date 2019/3/21 17:12
     * @param  id 用户Id
     * @return com.xiao5.ordercenter.common.entity.user.Users
     */
    NetResponse<Users> qryUsersById(Integer id);

    /**
     * 添加用户
     * @author Wu Tianbing
     * @date 2019-05-29 16:22
     * @param users 用户信息
     * @return int
     */
    int saveUser(Users users);

    /**
     * 根据用户ID 删除用户
     * @author Wu Tianbing
     * @date 2019-05-29 16:31
     * @param id 用户ID
     * @return int
     */
    int deleteUser(Integer id);

    /**
     * 修改用户信息
     * @author Wu Tianbing
     * @date 2019-05-29 17:34
     * @param users	 用户信息
     * @return int
     */
    int updateUser(Users users);
}

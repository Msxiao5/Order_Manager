package com.xiao5.ordercenter.dataorder.service;

import com.xiao5.ordercenter.common.entity.NetResponse;
import com.xiao5.ordercenter.common.entity.user.Users;

import java.util.List;

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
     */
    int saveUser(Users users);

    /**
     * 根据用户ID 删除用户
     * @author Wu Tianbing
     * @date 2019-05-29 16:31
     * @param id 用户ID
     */
    int deleteUser(Integer id);

    /**
     * 修改用户信息
     * @author Wu Tianbing
     * @date 2019-05-29 17:34
     * @param users	 用户信息
     */
    int updateUser(Users users);

    /**
     * 使用JPA查询所有数据
     * @author Wu Tianbing
     * @date 2019-05-29 20:52
     * @param
     * @return com.xiao5.ordercenter.common.entity.NetResponse<java.util.List<com.xiao5.ordercenter.common.entity.user.Users>>
     */
    List<Users> findAll();
}

package com.xiao5.ordercenter.dataorder.mapper;

import com.xiao5.ordercenter.common.entity.user.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * 用户Mapper
 * @author WuTian Bing
 * @date  2019/3/21 16:50
 * @version 1.0
 **/
@Mapper
public interface UsersMapper extends Serializable, JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users> {

    /**
     * 根据用户Id查询用户信息
     * @author Wu TianBing
     * @date 2019/3/21 17:12
     * @param  id 用户Id
     * @return com.xiao5.ordercenter.common.entity.user.Users
     */
    Users qryUsersById(@Param(value = "id") Integer id);

    /**
     * 保存用户信息
     * @author Wu Tianbing
     * @date 2019-05-29 17:30
     * @param users 用户信息
     * @return int
     */
    int saveUser(Users users);

    /**
     * 根据用户ID 删除用户信息
     * @author Wu Tianbing
     * @date 2019-05-29 17:30
     * @param id	用户ID
     * @return int
     */
    int deleteUser(@Param(value = "id") Integer id);

    /**
     * 修改用户信息
     * @author Wu Tianbing
     * @date 2019-05-29 17:34
     * @param users	 用户信息
     * @return int
     */
    int updateUser(Users users);
}

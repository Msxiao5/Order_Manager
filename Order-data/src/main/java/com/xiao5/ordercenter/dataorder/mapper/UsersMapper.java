package com.xiao5.ordercenter.dataorder.mapper;

import com.xiao5.ordercenter.common.entity.user.Users;
import org.apache.ibatis.annotations.*;

/**
 * 用户Mapper
 * @author WuTian Bing
 * @date  2019/3/21 16:50
 * @version 1.0
 **/
@Mapper
public interface UsersMapper {

    /**
     * 根据用户Id查询用户信息
     * @author Wu TianBing
     * @date 2019/3/21 17:12
     * @param  id 用户Id
     * @return com.xiao5.ordercenter.common.entity.user.Users
     */
    Users qryUsersById(@Param(value = "id") Integer id);

    @Insert("insert into USERS (id,name,password,age,remark,status) values (#{id},#{name},#{passWord},#{age},#{remark},#{status});")
    int saveUser(Users users);

    @Delete("delete from USERS where id = #{id}")
    int deleteUser(Integer id);
}

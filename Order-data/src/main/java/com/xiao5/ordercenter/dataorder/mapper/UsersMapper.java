package com.xiao5.ordercenter.dataorder.mapper;

import com.xiao5.ordercenter.dataorder.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
     * @return com.xiao5.ordercenter.dataorder.entity.Users
     */
    @Select("Select * from USERS where id = #{id}")
    Users qryUsersById(Long id);

}

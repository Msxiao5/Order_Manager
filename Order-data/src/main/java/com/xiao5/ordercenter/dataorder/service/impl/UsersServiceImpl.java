package com.xiao5.ordercenter.dataorder.service.impl;

import com.xiao5.ordercenter.common.code.BaseCode;
import com.xiao5.ordercenter.common.entity.NetResponse;
import com.xiao5.ordercenter.common.entity.user.Users;
import com.xiao5.ordercenter.common.enumType.exception.DataErrorEnum;
import com.xiao5.ordercenter.common.exception.BaseException;
import com.xiao5.ordercenter.common.utils.JsonHelper;
import com.xiao5.ordercenter.common.utils.RedisHelper;
import com.xiao5.ordercenter.dataorder.mapper.UsersMapper;
import com.xiao5.ordercenter.dataorder.repository.UserRepository;
import com.xiao5.ordercenter.dataorder.service.IUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户业务层
 * @author WuTian Bing
 * @version 1.0
 * @date 2019/3/21 16:45
 **/
@Slf4j
@Service
public class UsersServiceImpl implements IUsersService {

    /**
     * Mybatis 持久层
     */
    @Resource
    UsersMapper usersMapper;

    /**
     * Jpa持久层
     */
    @Autowired
    UserRepository userRepository;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 根据用户Id查询用户信息
     * @author Wu TianBing
     * @date 2019/3/21 17:12
     * @param  id 用户Id
     * @return com.xiao5.ordercenter.common.entity.user.Users
     */
    //@Cacheable(value = "Users", key ="#id")
    @Override
    public NetResponse<Users> qryUsersById(Integer id){
        NetResponse<Users> response = new NetResponse<>();
        log.info("【根据Id查询当前用户，当前Id={}】",id);
        Users users = usersMapper.qryUsersById(id);
        if (null == users){
            log.info("【当前用户ID:{}，无对应用户】",id);
            throw new BaseException(DataErrorEnum.USER_NOT_FOUND.getCode(), DataErrorEnum.USER_NOT_FOUND.getDesc());
        }
        RedisHelper.set(redisTemplate, "Users:" + id.toString(), JsonHelper.objectToJson(users));
        log.info("【当前Id = {},查询用户结果为：{}】",id ,users.toString());
        response.setResult(users);
        return response;
    }

    /**
     * 添加用户
     * @author Wu Tianbing
     * @date 2019-05-29 16:22
     * @param users 用户信息
     * @return int
     */
   // @CachePut(value = "Users", key = "#users.id")
    @Override
    public int saveUser(Users users) {
        log.info("【添加用户，当前Id={}】", users.getId());
        int count = usersMapper.saveUser(users);
        RedisHelper.set(redisTemplate, "Users:" + users.getId().toString(), JsonHelper.objectToJson(users));
        log.info("【当前Id = {},添加用户成功，用户信息为：{}】",users.getId() ,users.toString());
        return count;
    }

    /**
     * 根据用户ID 删除用户
     * @author Wu Tianbing
     * @date 2019-05-29 16:31
     * @param id 用户ID
     * @return int
     */
   // @CacheEvict(value = "Users" , key = "#id")
    @Override
    public int deleteUser(Integer id) {
        log.info("【根据用户ID 删除用户，当前Id={}】", id);
        int count = usersMapper.deleteUser(id);
        RedisHelper.delete(redisTemplate,"Users:" + id.toString());
        log.info("【当前Id = {},删除用户成功=】",id);
        return count;
    }

    /**
     * 修改用户信息
     * @author Wu Tianbing
     * @date 2019-05-29 17:34
     * @param users	 用户信息
     * @return int
     */
   // @CachePut(value = "Users", key = "#users.id")
    @Override
    public int updateUser(Users users) {
        log.info("【修改用户，当前Id={}】", users.getId());
        int count = usersMapper.updateUser(users);
        RedisHelper.set(redisTemplate, "Users:" + users.getId().toString(), JsonHelper.objectToJson(users));
        log.info("【修改用户成功，用户信息为：{}】",users.toString());
        return count;
    }

    /**
     * 使用JPA查询所有数据
     * @author Wu Tianbing
     * @date 2019-05-29 20:52
     * @param
     * @return com.xiao5.ordercenter.common.entity.NetResponse<java.util.List<com.xiao5.ordercenter.common.entity.user.Users>>
     */
  //  @Cacheable(value = "Users")
    @Override
    public List<Users> findAll() {
        log.info("【查询所有用户】");
        List<Users> userList = userRepository.findAll();
        RedisHelper.set(redisTemplate, "Users:All" , JsonHelper.objectToJson(userList));
        log.info("【查询所有用户成功，用户信息为：{}】",JsonHelper.objectToJson(userList));
        return userList;
    }
}

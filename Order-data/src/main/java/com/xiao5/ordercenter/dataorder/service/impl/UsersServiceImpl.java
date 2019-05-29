package com.xiao5.ordercenter.dataorder.service.impl;

import com.xiao5.ordercenter.common.entity.NetResponse;
import com.xiao5.ordercenter.common.entity.user.Users;
import com.xiao5.ordercenter.dataorder.mapper.UsersMapper;
import com.xiao5.ordercenter.dataorder.repository.UserRepository;
import com.xiao5.ordercenter.dataorder.service.IUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

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

    /**
     * 根据用户Id查询用户信息
     * @author Wu TianBing
     * @date 2019/3/21 17:12
     * @param  id 用户Id
     * @return com.xiao5.ordercenter.common.entity.user.Users
     */
    @Override
    public NetResponse<Users> qryUsersById(Integer id) {
        NetResponse<Users> response = new NetResponse<>();
        log.info("【根据Id查询当前用户，当前Id={}】",id);
        Users users = usersMapper.qryUsersById(id);
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
    @Override
    public int saveUser(Users users) {
        log.info("【添加用户，当前Id={}】", users.getId());
        int count = usersMapper.saveUser(users);
        if (count <= 0 ){
            log.error("保存用户失败");
        }
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
    @Override
    public int deleteUser(Integer id) {
        log.info("【根据用户ID 删除用户，当前Id={}】", id);
        int count = usersMapper.deleteUser(id);
        if (count <= 0 ){
            log.error("保存用户失败");
        }
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
    @Override
    public int updateUser(Users users) {
        log.info("【修改用户，当前Id={}】", users.getId());
        int count = usersMapper.updateUser(users);
        if (count <= 0 ){
            log.error("保存用户失败");
        }
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
    @Override
    public NetResponse<List<Users>> findAll() {
        NetResponse<List<Users>> netResponse = new NetResponse<>();
        List<Users> userList = userRepository.findAll();
        netResponse.setResult(userList);
        return netResponse;
    }
}

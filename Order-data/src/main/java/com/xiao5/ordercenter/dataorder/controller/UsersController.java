package com.xiao5.ordercenter.dataorder.controller;

import com.xiao5.ordercenter.common.entity.NetRequest;
import com.xiao5.ordercenter.common.entity.NetResponse;
import com.xiao5.ordercenter.common.entity.user.Users;
import com.xiao5.ordercenter.dataorder.service.IUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户controller
 * @author WuTian Bing
 * @version 1.0
 * @classname UsersController
 * @date 2019/3/21 16:44
 **/
@Slf4j
@RestController
@RequestMapping("/user")
public class UsersController {

    @Resource
    IUsersService usersService;

    /**
     * 根据用户Id查询用户信息
     * @author Wu TianBing
     * @date 2019/3/21 17:12
     * @param  id 用户Id
     * @return com.xiao5.ordercenter.common.entity.user.Users
     */
    @GetMapping("/qry/{id}")
    public NetResponse<Users> qryUsersById(@PathVariable("id") Integer id){
        //调用开始时间
        long startTimeMillis = System.currentTimeMillis();

        NetResponse<Users> netResponse = usersService.qryUsersById(id);
        if (null == netResponse.getResult()){
            log.info("【当前{}ID，无对应用户】",id);
            netResponse.setCode("9999");
            netResponse.setMassage("查询用户不存在");
            return netResponse;
        }
        //耗时
        long timeConsuming = System.currentTimeMillis() - startTimeMillis;
        log.info("【时长:{}毫秒】", timeConsuming);
        return netResponse;
    }

    /**
     * 保存用户
     * @author Wu Tianbing
     * @date 2019-05-29 16:48
     * @param request	请求对象
     * @return com.xiao5.ordercenter.common.entity.NetResponse
     */
    @PostMapping("/add")
    public NetResponse saveUser(@RequestBody NetRequest<Users> request){
        NetResponse netResponse = new NetResponse();
        //调用开始时间
        long startTimeMillis = System.currentTimeMillis();

        Users users = request.getRequest();
        netResponse = usersService.saveUser(users);
        //耗时
        long timeConsuming = System.currentTimeMillis() - startTimeMillis;
        log.info("【时长:{}毫秒】", timeConsuming);
        return netResponse;
    }
    /**
     * 根据用户ID 删除用户信息
     * @author Wu Tianbing
     * @date 2019-05-29 17:05
     * @param id	用户ID
     * @return com.xiao5.ordercenter.common.entity.NetResponse
     */
    @GetMapping("/delete/{id}")
    public NetResponse deleteUser(@PathVariable("id") Integer id){
        NetResponse netResponse = new NetResponse();
        //调用开始时间
        long startTimeMillis = System.currentTimeMillis();

        netResponse = usersService.deleteUser(id);
        //耗时
        long timeConsuming = System.currentTimeMillis() - startTimeMillis;
        log.info("【时长:{}毫秒】", timeConsuming);
        return netResponse;
    }

    /**
     * 修改用户信息
     * @author Wu Tianbing
     * @date 2019-05-29 17:35
     * @param request	用户信息
     * @return com.xiao5.ordercenter.common.entity.NetResponse
     */
    @PostMapping("/update")
    public NetResponse updateUser(@RequestBody NetRequest<Users> request){
        NetResponse netResponse = new NetResponse();
        //调用开始时间
        long startTimeMillis = System.currentTimeMillis();

        Users users = request.getRequest();
        netResponse = usersService.updateUser(users);
        //耗时
        long timeConsuming = System.currentTimeMillis() - startTimeMillis;
        log.info("【时长:{}毫秒】", timeConsuming);
        return netResponse;
    }

    /**
     * 使用JPA查询所有数据
     * @author Wu Tianbing
     * @date 2019-05-29 20:52
     * @param
     * @return com.xiao5.ordercenter.common.entity.NetResponse<java.util.List<com.xiao5.ordercenter.common.entity.user.Users>>
     */
    @GetMapping("/findAll")
    public NetResponse<List<Users>> select(){
        //调用开始时间
        long startTimeMillis = System.currentTimeMillis();

        NetResponse<List<Users>> netResponse = usersService.findAll();
        //耗时
        long timeConsuming = System.currentTimeMillis() - startTimeMillis;
        log.info("【时长:{}毫秒】", timeConsuming);
        return netResponse;
    }

}

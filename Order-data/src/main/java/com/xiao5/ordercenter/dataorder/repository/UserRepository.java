package com.xiao5.ordercenter.dataorder.repository;

import com.xiao5.ordercenter.common.entity.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Users JPA 数据持久层
 * @auther: Wu Tianbing
 * @date: 2019/5/29/029 19:27
 */
@Repository
public interface UserRepository extends Serializable, JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users> {

}

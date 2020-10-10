package com.xiao5.ordercenter.dataorder.mapper;

import com.xiao5.ordercenter.common.entity.Syslogs;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

@Mapper
public interface SysLogsMapper extends Serializable, JpaRepository<Syslogs, Integer>, JpaSpecificationExecutor<Syslogs> {

}

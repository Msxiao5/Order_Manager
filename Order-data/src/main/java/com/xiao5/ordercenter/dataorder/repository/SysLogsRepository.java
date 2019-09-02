package com.xiao5.ordercenter.dataorder.repository;

import com.xiao5.ordercenter.common.entity.Syslogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface SysLogsRepository extends Serializable, JpaRepository<Syslogs, Integer>, JpaSpecificationExecutor<Syslogs> {

}

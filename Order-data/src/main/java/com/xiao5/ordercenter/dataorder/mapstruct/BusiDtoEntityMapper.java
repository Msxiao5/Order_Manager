package com.xiao5.ordercenter.dataorder.mapstruct;

import com.xiao5.ordercenter.common.convert.EntityDtoTypeConvertor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * 实体转换类
 * @author WuTian Bing
 * @version 1.0
 * @date 2019/3/19 14:50
 **/
@Mapper(uses = EntityDtoTypeConvertor.class)
public interface BusiDtoEntityMapper {

    BusiDtoEntityMapper INSTANCE = Mappers.getMapper(BusiDtoEntityMapper.class);

}

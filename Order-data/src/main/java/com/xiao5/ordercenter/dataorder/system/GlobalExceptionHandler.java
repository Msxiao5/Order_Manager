package com.xiao5.ordercenter.dataorder.system;

import com.xiao5.ordercenter.common.code.BaseCode;
import com.xiao5.ordercenter.common.entity.NetResponse;
import com.xiao5.ordercenter.common.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther: Wu Tianbing
 * @date: 2019/6/4/004 11:44
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public NetResponse<Object> baseErrorHandler(BaseException e){
        log.error("捕获自定义异常：", e);
        return new NetResponse<>(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public NetResponse<Object> exceptionErrorHandler(Exception e){
        log.error("捕获未知异常：", e);
        return new NetResponse<>(BaseCode.FAIL.getCode(), e.getMessage());
    }
}

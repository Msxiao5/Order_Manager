package com.xiao5.ordercenter.dataorder.system.aspect;

import com.xiao5.ordercenter.common.annotation.Logs;
import com.xiao5.ordercenter.common.entity.Syslogs;
import com.xiao5.ordercenter.common.utils.IPUtils;
import com.xiao5.ordercenter.common.utils.JsonHelper;
import com.xiao5.ordercenter.dataorder.mapper.SysLogsMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @auther: Wu Tianbing
 * @date: 2019/6/5/005 14:41
 */
@Slf4j
@Aspect
@Component
@Order
public class SysLogsAspect {

    @Autowired
    SysLogsMapper sysLogsMapper;


    @Pointcut("@annotation(com.xiao5.ordercenter.common.annotation.Logs)")
    public void pointcut(){ }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            // 执行方法
            result = point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        // 保存日志
        saveLog(point);
        return result;
    }

    private void saveLog(ProceedingJoinPoint point) {

        Syslogs syslogs = new Syslogs();
        syslogs.setId(Integer.valueOf((int)Math.random()*100));

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        Logs logs = method.getAnnotation(Logs.class);
        if (logs != null){
            syslogs.setType(logs.type());
            syslogs.setMethod(logs.value());
        }

        Object[] args = point.getArgs();
        syslogs.setParams(JsonHelper.objectToJson(args));

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        // 请求地址
        syslogs.setRemoteAddr(IPUtils.getIpAddr(request));
        // 请求URL
        syslogs.setRequestUri(request.getRequestURI());
        // 浏览器
        syslogs.setUserAgent(request.getHeader("User-Agent"));
        // 时间
        syslogs.setCreateDate(new Date());

        sysLogsMapper.save(syslogs);
    }

}

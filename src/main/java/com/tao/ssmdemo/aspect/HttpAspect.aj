package com.tao.ssmdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by TAO on 2018/10/8.
 */
@Aspect
@Component
public class HttpAspect {
    private Logger log = LoggerFactory.getLogger(getClass().getName());
    private ObjectError error;

    @Pointcut("execution(public * com.tao.ssmdemo.controller.*.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doLog(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("---------------请求内容---------------");
        log.info("请求地址url={}",request.getRequestURI().toString());
        log.info("请求方式={}",request.getMethod());
        log.info("ip={}",request.getRemoteAddr());
        log.info("请求类方法："+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        log.info("请求类方法参数"+ Arrays.toString(joinPoint.getArgs()));
    }

    @After("log()")
    public void doAfterLog(JoinPoint joinPoint){
        log.info("2222222222222");
    }

    @AfterReturning(returning="obj",value="log()")
    public void doAfterReturnig(Object obj){
        log.info("reponse={}", obj);
    }

}

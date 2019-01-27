package com.archer.aop.springaop;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
@Aspect
public class InvokeAop {

    private Logger log = LoggerFactory.getLogger(InvokeAop.class);

    @Pointcut("@annotation(com.archer.ats.annotion.TimerAnnotion)")
    public void timerAnnotion() {

    }

    @Around("timerAnnotion()")
    public void around(JoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("AGRGS" + JSON.toJSONString(joinPoint.getArgs(), SerializerFeature.WriteClassName));
        log.info("请求耗时：" + Long.toString(System.currentTimeMillis() - start));
    }
}

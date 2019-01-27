package com.archer.aop.springaop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class WebLogAspect {


    @Pointcut("execution(public * com.archer.controller.HelloController.*.*(..))")
    public void webLog() {
    }

    @Pointcut("@annotation(com.archer.annation.AopAnnation)")
    public void annationLog() {

    }

    private long start;

    @Before("annationLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        start = System.currentTimeMillis();
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

        log.info("AGRGS" + JSON.toJSONString(joinPoint.getArgs(), SerializerFeature.WriteClassName));
    }

    @After("annationLog()")
    public void doAfter() {
        log.info("请求耗时：" + Long.toString(System.currentTimeMillis() - start));
    }

    @AfterReturning(returning = "ret", pointcut = "annationLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("RESPONSE : " + ret);
    }

}
package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);



    @Pointcut("execution( public * com.example.demo.controller.MoneyController.*(..))")
    public void info(){
    }

    @Before("info()")
    public void before(JoinPoint joinPoint){
        //System.out.println("你是个大傻子！");
        //logger.info("你是个大傻子！");
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());

        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //l类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "."+joinPoint.getSignature().getName());
        //信息
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("info()")
    public  void infoAfter(){
        //System.out.println("你还是个大傻子！");
        logger.info("你还是个大傻子！");
    }

    @AfterReturning(returning = "object",pointcut = "info()")
    public void afterReturning(Object object){
        logger.info("response={}",object);
    }
}

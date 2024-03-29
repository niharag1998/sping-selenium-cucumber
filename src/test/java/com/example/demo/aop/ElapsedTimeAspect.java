package com.example.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Slf4j
public class ElapsedTimeAspect {
    @Around("@annotation(com.example.demo.annotation.ElapsedTime)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object obj = proceedingJoinPoint.proceed();
        long duration = System.currentTimeMillis() - startTime;
        log.info("Elapsed time of {} class's {} method is {}", proceedingJoinPoint
                        .getSignature()
                        .getDeclaringTypeName(),
                proceedingJoinPoint
                        .getSignature()
                        .getName(), duration + " ms.");
        return obj;
    }
}

package com.example.rabbit.aspect;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Slf4j
@Component
public class MonitorAspect {

    /**
     * 切点
     */
    @Pointcut("@annotation(monitor)")
    public void pointCut(Monitor monitor) {
    }

//    @Around("pointCut(monitor)")
//    public Object userAdvice(ProceedingJoinPoint pjp, Monitor monitor) throws Throwable {
//        StopWatch stopWatch = new StopWatch(getClass().getSimpleName());
//        try {
//            stopWatch.start();
//            pjp.proceed();
//        } finally {
//            stopWatch.stop();
//            System.out.println(stopWatch.prettyPrint());
//        }
//        return null;
//    }


//    @Before("pointCut(monitor)")
//    public void doBefore(Monitor monitor) {
//        stopWatch = StopWatch.createStarted();
//    }
//
//    @After("pointCut(monitor)")
//    public void doAfter(Monitor monitor) {
//        stopWatch.stop();
//        System.out.println(stopWatch.getTime(TimeUnit.MILLISECONDS));
//    }

    @Around(value = "pointCut(monitor)", argNames = "joinPoint,monitor")
    public Object doAround(ProceedingJoinPoint joinPoint, Monitor monitor) throws Throwable {
        StopWatch stopWatch = StopWatch.createStarted();
        Object result = joinPoint.proceed();
        stopWatch.stop();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String name = methodSignature.getMethod().getName();
        log.info("invoke method {} takes {} sec", name, stopWatch.getTime(TimeUnit.SECONDS));
        return result;
    }
}

package com.example.rabbit.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RateLimitAspect {
//    @Pointcut("@annotation(com.example.rabbit.aspect.RateLimit)")
//    private void getPointCut(){}

    @Before(value = "@annotation(rateLimit)")
    public void doBefore(JoinPoint joinPoint, RateLimit rateLimit){
        int qps = rateLimit.qps();
    }

}

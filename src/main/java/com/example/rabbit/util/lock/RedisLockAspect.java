package com.example.rabbit.util.lock;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.redisson.Redisson;
import org.redisson.api.LockOptions;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class RedisLockAspect {
    private final RedissonClient redissonClient = Redisson.create();
    private final String myLock = "redis_lock";
    RLock lock = redissonClient.getLock(myLock);

    @Before("@annotation(RedisLock)")
    public void doBefore() throws InterruptedException {
        while (!lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
            System.out.println(Thread.currentThread().getName() + " is trying to get lock");
        }
        System.out.println(Thread.currentThread().getName() + " succeed to get lock");
        lock.lock(10000, TimeUnit.MILLISECONDS);
    }

    @After("@annotation(RedisLock)")
    public void doAfter() {
            lock.unlock();
           System.out.println(Thread.currentThread().getName() + " succeed to release lock");
    }
}

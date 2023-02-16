package com.example.rabbit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;

@SpringBootTest
class RabbitApplicationTests {
    @Autowired
    private StringRedisTemplate redisTemplate;


    //    @BeforeAll
//    void setRedisTemplate(){
//        redisTemplate =
//    }
    @Test
    void contextLoads() {
    }

    @Test
    public void t1() {
        List<String> str = redisTemplate.opsForList().range("什么什么key", 0, 2);
        System.out.println(str);
    }

    @Test
    public void t2() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.submit(() -> {
            List<String> strings = redisTemplate.opsForList().range("member-key", 0, -1);
            System.out.println(strings);
            Boolean delete = redisTemplate.delete("member-key");
            System.out.println("deleted" + delete);
        });
    }

    @Test
    public void t3(){
        for (int i = 0; i < 100; i++) {
            redisTemplate.opsForList().leftPush("member-key", String.valueOf(i));
        }
        System.out.println(redisTemplate.opsForList().size("member-key"));
    }
}

package com.example.rabbit.util;

import com.example.rabbit.util.lock.RedisLock;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class RedisUtil<K, V> {
    private final RedisTemplate<K, V> redisTemplate;
    public static final String catgeory = "test:";

    public RedisUtil(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    public strictfp void set(K key, V val) {

        redisTemplate.opsForValue().set(key, val);
    }


    @RedisLock
    public strictfp List<V> get(List<K> keys) {

        return redisTemplate.opsForValue().multiGet(keys);
    }

    public Map<Object, Object> get(K keys) {

        return redisTemplate.opsForHash().entries(keys);
    }
}

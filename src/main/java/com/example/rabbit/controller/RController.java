package com.example.rabbit.controller;

import com.example.rabbit.util.RedisUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class RController {
    private final RedisUtil<String, Integer> redisUtil;
    private final RedisUtil<String, Map<String, String>> redisUtil1;

    public RController(RedisUtil<String, Integer> redisUtil, RedisUtil<String, Map<String, String>> redisUtil1) {
        this.redisUtil = redisUtil;
        this.redisUtil1 = redisUtil1;
    }
    @RequestMapping(value = "/red1", method = RequestMethod.POST)
    public void send(@RequestParam("key")String key, @RequestParam("val")Integer val){
        redisUtil.set(key, val);
    }

    @RequestMapping(value = "/red2", method = RequestMethod.POST)
    public List<Integer> get(@RequestBody List<String> keys){
        return redisUtil.get(keys);
    }


    @RequestMapping(value = "/red3", method = RequestMethod.DELETE)
    public Integer get(@RequestParam("path") String path, @RequestParam("taskId")Long id){
        return 1;
    }


}

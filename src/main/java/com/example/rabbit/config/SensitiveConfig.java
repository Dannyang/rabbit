package com.example.rabbit.config;


import org.ahocorasick.trie.Trie;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SensitiveConfig {
    @Value("${sensitive.words}")
    private String words;

    @Bean
    public Trie getTire() {
        Trie.TrieBuilder builder = Trie.builder();
        String[] ws = words.split(",");
        for (String str : ws) {
            builder.addKeyword(str);
        }
        return builder.build();
    }

//    @Bean
//    public RedissonClient getRedissonClient(){
//        return new RedissonClient();
//    }
}

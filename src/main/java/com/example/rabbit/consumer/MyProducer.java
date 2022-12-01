package com.example.rabbit.consumer;

import com.example.rabbit.entity.Entity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyProducer {
    private final RabbitTemplate rabbitTemplate;

    public MyProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(Entity entity){
        rabbitTemplate.convertAndSend("oneEx",entity.getKey(), entity.getMsg());
    }
}

package com.example.rabbit.consumer;

import com.alibaba.fastjson.JSON;
import com.example.rabbit.entity.DHRApprovalVo;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyConsumer {
//    @RabbitListener(queues = "oneQ")
//    public void con1(List<String> msg) {
//        System.out.println("con1____________________________________" + JSON.toJSONString(msg));
//    }


//    @RabbitListener(queues = "oneQ2")
//    public void con2(String msg) {
//        System.out.println("oneQ2___________________________________" + msg);
//    }
//
//
//    @RabbitListener(queues = "oneQ3")
//    public void con3(String msg) {
//        System.out.println("con3_____________________________________" + msg);
//    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "dhr.queue"),
            exchange = @Exchange(value = "oneEx"),
            key = "dhr.approval.task"))
    public void con3(DHRApprovalVo vo) {
        System.out.println("con3_____________________________________" + JSON.toJSONString(vo));
    }
}

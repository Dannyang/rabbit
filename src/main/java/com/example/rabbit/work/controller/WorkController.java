package com.example.rabbit.work.controller;

import com.mysteel.member.member.Member;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkController {
    private final RabbitTemplate rabbitTemplate;

    public WorkController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/sent")
    public void sent(){
        Member member = new Member();
        member.setId(8464578L);
        member.setManagerId(216431L);
        rabbitTemplate.convertAndSend("1100.0600.sososteel-mgt-webapp.admin.routeKey", member);
    }

}

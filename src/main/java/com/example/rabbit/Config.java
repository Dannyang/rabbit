package com.example.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class Config {
//    @Autowired
//    private CachingConnectionFactory connectionFactory;
//    @Autowired
//    private Receiver receiver;
//
//    @Bean
//    public MessageConverter messageConverter(ObjectMapper objectMapper) {
//        return new Jackson2JsonMessageConverter(objectMapper);
//    }
//
//    @Bean
//    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
//        //消费者数量，默认10
//        int DEFAULT_CONCURRENT = 10;
//
//        //每个消费者获取最大投递数量 默认50
//        int DEFAULT_PREFETCH_COUNT = 50;
//
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
//        container.setConcurrentConsumers(DEFAULT_CONCURRENT);
//        container.setMaxConcurrentConsumers(DEFAULT_PREFETCH_COUNT);
//
//        // RabbitMQ默认是自动确认，这里改为手动确认消息
//        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//
//        //设置一个队列
//        container.setQueueNames("ehr.queue");
//
//        //如果同时设置多个如下： 前提是队列都是必须已经创建存在的
//        //container.setQueueNames("TestDirectQueue","TestDirectQueue2","TestDirectQueue3");
//        //另一种设置队列的方法,如果使用这种情况,那么要设置多个,就使用addQueues
//        //container.setQueues(new Queue("TestDirectQueue",true));
//        //container.addQueues(new Queue("TestDirectQueue2",true));
//        //container.addQueues(new Queue("TestDirectQueue3",true));
//
//        container.setMessageListener(receiver);
//
//        return container;
//    }


    @Bean
    public Queue queue3(){
        return new Queue("queue_mysteel-large-port-workbench_admin-transfer");
    }
    @Bean
    public DirectExchange exchange(){
        return new DirectExchange("1100.0600.sososteel-mgt-webapp.admin.exchange");
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue3()).to(exchange()).with("1100.0600.sososteel-mgt-webapp.admin.routeKey");
    }

}

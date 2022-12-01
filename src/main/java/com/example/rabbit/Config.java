package com.example.rabbit;

import com.example.rabbit.consumer.Receiver;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRabbit
public class Config {
    @Autowired
    private CachingConnectionFactory connectionFactory;
    @Autowired
    private Receiver receiver;

    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
        //消费者数量，默认10
        int DEFAULT_CONCURRENT = 10;

        //每个消费者获取最大投递数量 默认50
        int DEFAULT_PREFETCH_COUNT = 50;

        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(DEFAULT_CONCURRENT);
        container.setMaxConcurrentConsumers(DEFAULT_PREFETCH_COUNT);

        // RabbitMQ默认是自动确认，这里改为手动确认消息
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);

        //设置一个队列
        container.setQueueNames("ehr.queue");

        //如果同时设置多个如下： 前提是队列都是必须已经创建存在的
        //container.setQueueNames("TestDirectQueue","TestDirectQueue2","TestDirectQueue3");
        //另一种设置队列的方法,如果使用这种情况,那么要设置多个,就使用addQueues
        //container.setQueues(new Queue("TestDirectQueue",true));
        //container.addQueues(new Queue("TestDirectQueue2",true));
        //container.addQueues(new Queue("TestDirectQueue3",true));

        container.setMessageListener(receiver);

        return container;
    }
//    @Bean
//    public Queue queue(){
//        return new Queue("oneQ");
//    }
//
//    @Bean
//    public Queue queue2(){
//        return new Queue("oneQ2");
//    }
//
//    @Bean
//    public Queue queue3(){
//        return new Queue("oneQ3");
//    }
//    @Bean
//    public DirectExchange exchange(){
//        return new DirectExchange("oneEx");
//    }
//
//    @Bean
//    public Binding bind1(){
//        return BindingBuilder.bind(queue()).to(exchange()).with("oneR");
//    }
//
//    @Bean
//    public Binding bind2(){
//        return BindingBuilder.bind(queue2()).to(exchange()).with("twoR");
//    }

    //    @Bean
//    public Binding bind3(){
//        return BindingBuilder.bind(queue3()).to(exchange()).with("threeR");
//    }
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        jackson2JsonRedisSerializer.setObjectMapper(new ObjectMapper());

        RedisSerializer stringSerializer = new StringRedisSerializer();

        template.setKeySerializer(stringSerializer);
        template.setValueSerializer(jackson2JsonRedisSerializer);

        template.setHashKeySerializer(stringSerializer);
        template.setHashValueSerializer(jackson2JsonRedisSerializer);

        return template;
    }
}

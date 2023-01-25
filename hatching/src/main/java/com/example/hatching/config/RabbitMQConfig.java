package com.example.hatching.config;

import com.example.hatching.queue.Sender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue hello() {
        return new Queue("hello");
    }

    @Bean
    public Sender sender() {
        return new Sender();
    }
}

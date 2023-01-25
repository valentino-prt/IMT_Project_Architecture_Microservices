package com.example.hatching.queue;

import com.example.hatching.web.Model.Egg;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class Sender {
    @Autowired
    private RabbitTemplate template;
    @Autowired
    private Queue queue;

    public String send(Egg egg) {
        String hatching_message = new String("good news : " + egg.getName() + "hatched");
        template.convertAndSend(queue.getName(), hatching_message);
        return " [x] Sent '" + hatching_message + "'";
    }
}

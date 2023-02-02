package com.example.hatching.queue;

import com.example.hatching.web.Model.Egg;
import com.example.hatching.web.Model.Pokemon;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class Sender {
    @Autowired
    private RabbitTemplate template;
    @Autowired
    private Queue queue;

    public String send(Pokemon pokemon) {
        String hatching_message = new String(pokemon.getName() + ";" + pokemon.getLevel()+ ";" + pokemon.getPicture());
        template.convertAndSend(queue.getName(), hatching_message);
        return " [x] Sent '" + hatching_message + "'";
    }
}

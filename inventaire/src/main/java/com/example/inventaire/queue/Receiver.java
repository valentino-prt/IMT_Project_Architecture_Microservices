package com.example.inventaire.queue;

import com.example.inventaire.web.Model.Pokemon;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import com.example.inventaire.web.Service.InventaireService;

@RabbitListener(queues = "hello")
public class Receiver {
    @Autowired
    private InventaireService inventaireService;
    @RabbitHandler
    public void receive(String in) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println("[x] Received '" + in + "'");

        doWork(in);
        watch.stop();
        System.out.println("[x] Done in " + watch.getTotalTimeSeconds() + "s");
    }

    private void doWork(String in) throws InterruptedException {
        Pokemon pokemon = new Pokemon(in);
        System.out.println(pokemon.getName() + " " + pokemon.getLevel());
        inventaireService.savePokemon(pokemon);
    }
}
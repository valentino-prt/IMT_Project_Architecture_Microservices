package com.example.inventaire.queue;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

import java.util.Random;
import java.util.Scanner;

@RabbitListener(queues = "hello")
public class Receiver {

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
//        Scanner myObj = new Scanner(System.in);
//        String input = null;
//        System.out.println("Would you like to keep this funcking Pokemon in your inventory? (y/n)");
//        while (input =='y' || input =='n'){
//            input = myObj.nextLine();
//        }
//        if (input == 'y'){
//            // add pokemon to his inventory
//
//
//        }
//        // if n : nothing to do
        System.out.println("I need to do some work");

    }
}
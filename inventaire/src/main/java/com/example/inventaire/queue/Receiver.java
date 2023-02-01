package com.example.inventaire.queue;

import com.example.inventaire.web.Model.Pokemon;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import com.example.inventaire.web.Service.InventaireService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@RabbitListener(queues = "hello")
public class Receiver {
    @Autowired
    private InventaireService inventaireService;
    @RabbitHandler
    public void receive(String in) throws InterruptedException, IOException {
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println("[x] Received '" + in + "'");

        doWork(in);
        watch.stop();
        System.out.println("[x] Done in " + watch.getTotalTimeSeconds() + "s");
    }

    private void doWork(String in) throws InterruptedException, IOException {
        Pokemon pokemon = new Pokemon(in);
        System.out.println(pokemon.getName() + " " + pokemon.getLevel());
        if(inventaireService.countPokemon() < 6) {
            inventaireService.savePokemon(pokemon);
        }
        else{
            System.out.println("Do you want to keep the Pokemon ?");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            // Reading data using readLine
            String input = reader.readLine();
            if(input.equals("yes")){
                List<Pokemon> poke = inventaireService.getAllPokemons();

                for(Pokemon pokemon1 : poke) {
                    System.out.println(pokemon1.getName() + " " + "lvl" + pokemon1.getLevel() + " " + pokemon1.getId());
                }
                System.out.println("Which Pokemon do you want to delete ? [Enter id]");

                BufferedReader reader1 = new BufferedReader(
                        new InputStreamReader(System.in));

                Integer input1 = Integer.valueOf(reader1.readLine());
                inventaireService.deletePokemon(input1);
                inventaireService.savePokemon(pokemon);
            }
            else{

                System.out.println(pokemon.getName() + " not kept");
            }
            //afficher les pokémons si oui et rentrer l'id du pokémon avec lequel on veut l"échanger
        }
    }
}
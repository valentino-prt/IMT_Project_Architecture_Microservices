package com.example.hatching.web.Service;

import com.example.hatching.queue.Sender;
import com.example.hatching.web.Model.Pokemon;
import com.example.hatching.web.Repository.HatchingRepository;
import com.example.hatching.web.Model.Egg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class HatchingService {
    @Autowired
    private HatchingRepository hatchingRepository;
    @Autowired
    private Sender sender;

    public Egg save(Egg egg) {
        return hatchingRepository.save(egg);
    }

    public List<Egg> getAllEggs() {
        return (List<Egg>) hatchingRepository.findAll();
    }

    public void sendMessage(Pokemon pokemon) {
        this.sender.send(pokemon);
    }


    @Scheduled(fixedRate = 5000)
    public void watchEgg() {
        List<Egg> oeuf = (List<Egg>) hatchingRepository.findAll();

        for(Egg egg : oeuf){
            int sec = egg.getDateDeposit().getSeconds();
            int second = egg.getHatchingTime()*60 + sec;
            Date evolution = egg.getDateDeposit();
            evolution.setSeconds(second);
            Date dateNow = new Date();
            if(evolution.getTime() <= dateNow.getTime())
            {
                Random rand = new Random();

                int int_random = rand.nextInt(100);

                String eggName = egg.getName();
                Pokemon generatedPokemon = new Pokemon();
                generatedPokemon.setName(eggName);
                generatedPokemon.setNo(egg.getNo());
                generatedPokemon.setLevel(int_random);
                hatchingRepository.delete(egg);
                sendMessage(generatedPokemon);

            }
        }
    }
}

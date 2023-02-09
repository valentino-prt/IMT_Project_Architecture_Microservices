package com.example.store.web.service;

import com.example.store.web.model.Egg;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RandomGeneratorService {
    private final List<String> pokemonNames;
    private static final String COMMA_DELIMITER = String.valueOf(';');

    public RandomGeneratorService(){
        List<String> records = new ArrayList<>();
        try (
                BufferedReader br = new BufferedReader(new FileReader("store/src/main/resources/pokedex.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                records.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.pokemonNames = records;

    }


    public Egg getEgg(){
        Egg egg = new Egg();
        egg.setHatchingTime(this.getRandomInteger(50));
        egg.setLevel(this.getRandomInteger(100));
        egg.setPrice(this.getRandomInteger(150));
        String[] noAndName = this.getRandomName();
        egg.setNo(Integer.valueOf(noAndName[0]));
        egg.setName(noAndName[1]);
        return egg;
    }
    public List<Egg> getListEgg(){
        List<Egg> listegg = new ArrayList<Egg>();
        for(int i=0; i<6; i++){
            Egg egg = new Egg();
            egg.setHatchingTime(this.getRandomInteger(50));
            egg.setLevel(this.getRandomInteger(100));
            egg.setPrice(this.getRandomInteger(150));
            String[] noAndName = this.getRandomName();
            egg.setNo(Integer.valueOf(noAndName[0]));
            egg.setName(noAndName[1]);
            listegg.add(i,egg);
        }
        System.out.println(listegg);
        return listegg;
    }
    private Integer getRandomInteger(Integer max){
        Random rand = new Random();
        return rand.nextInt(max);
    }

    private String[] getRandomName(){
        String str = pokemonNames.get(this.getRandomInteger(pokemonNames.size()-1));
        String[] noAndName = str.split(COMMA_DELIMITER);

        return noAndName;
    }

}

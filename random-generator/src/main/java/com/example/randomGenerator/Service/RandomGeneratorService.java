package com.example.randomGenerator.Service;
import com.example.randomGenerator.Model.Egg;
import com.example.randomGenerator.Model.Pokemon;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class RandomGeneratorService {
    private final List<String> pokemonNames;

    public RandomGeneratorService(){
        List<String> records = new ArrayList<>();
        try (
                BufferedReader br = new BufferedReader(new FileReader("random-generator/src/main/resources/pokedex.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                records.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.pokemonNames = records;

    }

    public Pokemon getPokemon(){
        Pokemon pokemon = new Pokemon();
        pokemon.setLevel(this.getRandomInteger(100));
        pokemon.setName(this.getRandomName());
        return pokemon;
    }

    public Egg getEgg(){
        Egg egg = new Egg();
        egg.setHatchingTime(this.getRandomInteger(50));
        egg.setName(this.getRandomName());
        return egg;
    }

    private Integer getRandomInteger(Integer max){
        Random rand = new Random();
        return rand.nextInt(max);
    }

    private String getRandomName(){
        return pokemonNames.get(this.getRandomInteger(pokemonNames.size()-1));
    }
}

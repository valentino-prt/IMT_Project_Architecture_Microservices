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
    private static final String COMMA_DELIMITER = String.valueOf(';');

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
        String[] noAndName = this.getRandomName();
        pokemon.setName(noAndName[1]);
        pokemon.setNo(Integer.valueOf(noAndName[0]));
        return pokemon;
    }

    public Egg getEgg(){
        Egg egg = new Egg();
        egg.setHatchingTime(this.getRandomInteger(50));
        String[] noAndName = this.getRandomName();
        egg.setNo(Integer.valueOf(noAndName[0]));
        egg.setName(noAndName[1]);
        return egg;
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

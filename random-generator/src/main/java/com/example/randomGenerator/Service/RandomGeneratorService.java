package com.example.randomGenerator.Service;
import com.example.randomGenerator.Model.Egg;
import com.example.randomGenerator.Model.Pokemon;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class RandomGeneratorService {

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
        Random rand = new Random(max);
        return rand.nextInt(max);
    }

    private String getRandomName(){
        List<String> pokemonNames = Arrays.asList("Pikachu", "Ratata", "Rototo");
        return pokemonNames.get(this.getRandomInteger(pokemonNames.size()-1));
    }
}

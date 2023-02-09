package com.example.store.web.service;

import com.example.store.web.model.Egg;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.store.web.Repository.StoreRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@EnableScheduling
@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;
    private final List<String> pokemonNames;
    private static final String COMMA_DELIMITER = String.valueOf(';');

    public StoreService(){
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
    private Integer getRandomInteger(Integer max){
        Random rand = new Random();
        return rand.nextInt(max);
    }

    private String[] getRandomName(){
        String str = pokemonNames.get(this.getRandomInteger(pokemonNames.size()-1));
        String[] noAndName = str.split(COMMA_DELIMITER);
        return noAndName;
    }

    public List<Egg> getAllEgg() {
        return (List<Egg>) storeRepository.findAll();
    }

    public void removeEgg(Integer id){
        storeRepository.deleteById(id);
    }

    public void deleteAllEgg(){
        storeRepository.deleteAll();
    }


    public Egg getById(Integer id){

        Optional<Egg> egg = storeRepository.findById(id);
        if (egg.isPresent()){
            return egg.get();
        }else {
            return null;
        }
    }
    @Scheduled(fixedRate = 60000)
    public void generateListEgg(){

        if(storeRepository.count() >= 6){
                storeRepository.deleteAll();
        }
        List<Egg> listegg = new ArrayList<Egg>();
        for (int i = 0; i < 6; i++) {
            Egg egg = new Egg();
            egg.setHatchingTime(this.getRandomInteger(50));
            egg.setLevel(this.getRandomInteger(100));
            egg.setPrice(this.getRandomInteger(150));
            String[] noAndName = this.getRandomName();
            egg.setNo(noAndName[0]);
            egg.setName(noAndName[1]);
            listegg.add(i, egg);
            storeRepository.save(egg);
            }
    }
}

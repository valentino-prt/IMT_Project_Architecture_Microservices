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
import java.util.*;

@EnableScheduling
@Service
public class StoreService {

    private static final String COMMA_DELIMITER = String.valueOf(';');
    private final List<String> pokemonNames;
    @Autowired
    private StoreRepository storeRepository;

    public StoreService() {
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

    private Integer getRandomInteger(Integer max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }

    private String[] getRandomName() {
        String str = pokemonNames.get(this.getRandomInteger(pokemonNames.size() - 1));
        return str.split(COMMA_DELIMITER);
    }

    public List<Egg> getAllEgg() {
        return (List<Egg>) storeRepository.findAll();
    }

    public Map<String, String> removeEgg(Integer id) {
        storeRepository.deleteById(id);
        Map<String, String> map = new HashMap<>();
        map.put("status", "success");
        map.put("message", "Egg removed to market");
        return map;
    }

    public void deleteAllEgg() {
        storeRepository.deleteAll();
    }


    public Egg getById(Integer id) {

        Optional<Egg> egg = storeRepository.findById(id);
        return egg.orElse(null);
    }

    @Scheduled(fixedRate = 60000)
    public void generateListEgg() {

        if (storeRepository.count() >= 6) {
            storeRepository.deleteAll();
        }
        List<Egg> listegg = new ArrayList<>();
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

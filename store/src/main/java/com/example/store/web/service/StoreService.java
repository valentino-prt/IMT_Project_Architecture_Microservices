package com.example.store.web.service;

import com.example.store.web.model.Egg;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.store.web.Repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public Egg save(Egg egg) {
        return storeRepository.save(egg);
    }

    public List<Egg> getAllEgg() {
        return (List<Egg>) storeRepository.findAll();
    }

    public void removeEgg(Integer id){
        storeRepository.deleteById(id);
    }

    public Egg getById(Integer id){

        Optional<Egg> egg = storeRepository.findById(id);
        if (egg.isPresent()){
            return egg.get();
        }else {
            return null;
        }
    }

}

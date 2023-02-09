package com.example.store.web.controller;

import com.example.store.web.service.RandomGeneratorService;
import com.example.store.web.service.StoreService;
import com.example.store.web.model.Egg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/eggs")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/refreshStore")
    public Boolean refreshStore(){
        return null;
    }


    @PostMapping(path="/add")
    public Egg addToSell(@RequestBody Egg egg){
        return storeService.save(egg);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Egg> getEggToSell() {
        // This returns a JSON or XML with the users
        return storeService.getAllEgg();
    }

    @DeleteMapping("{id}")
    public void removeSoldEgg(@PathVariable int id){
        storeService.removeEgg(id);
    }

    @GetMapping(path = "/get/{id}")
    public @ResponseBody Egg getPrice(@PathVariable int id){
        return storeService.getById(id);
    }
    @Autowired
    private RandomGeneratorService randomGeneratorService;

    @GetMapping("/get_egg")
    public @ResponseBody Egg getEgg() {
        // This returns a JSON or XML with the users
        return randomGeneratorService.getEgg();
    }
    @GetMapping("/list_egg")
    public @ResponseBody List<Egg> listegg(){
        return randomGeneratorService.getListEgg();
    }

}
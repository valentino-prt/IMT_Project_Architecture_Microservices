package com.example.store.web.controller;

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


    @GetMapping(path="/all")
    public @ResponseBody Iterable<Egg> getEggToSell() {
        // This returns a JSON or XML with the users
        return storeService.getAllEgg();
    }

    @DeleteMapping("/remove")
    public @ResponseBody void removeSoldEgg(@RequestParam int id){
        storeService.removeEgg(id);
    }

    @GetMapping(path = "/get_egg")
    public @ResponseBody Egg getPrice(@RequestParam int id){
        return storeService.getById(id);
    }

    @GetMapping("/list_egg")
    public @ResponseBody List<Egg> listegg(){
        return storeService.getListEgg();
    }

}
package com.example.store.web.controller;

import com.example.store.web.service.StoreService;
import com.example.store.web.model.Egg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/eggs")
@CrossOrigin(origins = "*")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/refreshStore")
    public Boolean refreshStore() {
        return null;
    }
    @GetMapping(path = "/getAllEggToBuy")
    public @ResponseBody Iterable<Egg> getEggToSell() {
        // This returns a JSON or XML with the users
        return storeService.getAllEgg();
    }

    @DeleteMapping("/removeEgg")
    public @ResponseBody void removeSoldEgg(@RequestParam int id) {
        storeService.removeEgg(id);
    }


    @GetMapping(path = "/getPriceEgg")
    public @ResponseBody Integer getPrice(@RequestParam int id) {
        Egg egg = storeService.getById(id);
        return egg.getPrice();
    }

    @DeleteMapping("/deleteAllEgg")
    public @ResponseBody void delete_all() {
         storeService.deleteAllEgg();
    }

}
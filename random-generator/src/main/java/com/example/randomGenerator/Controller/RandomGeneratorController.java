package com.example.randomGenerator.Controller;

import com.example.randomGenerator.Model.Egg;
import com.example.randomGenerator.Model.Pokemon;
import com.example.randomGenerator.Service.RandomGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
public class RandomGeneratorController {

    @Autowired
    private RandomGeneratorService randomGeneratorService;

    @GetMapping("/get_egg")
    public @ResponseBody Egg getEgg() {
        // This returns a JSON or XML with the users
        return randomGeneratorService.getEgg();
    }

    @GetMapping("/get_pokemon")
    public @ResponseBody Pokemon getPokemon() {
        // This returns a JSON or XML with the users
        return randomGeneratorService.getPokemon();
    }

}

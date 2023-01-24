package com.example.inventaire.Controller;

import com.example.inventaire.Model.Pokemon;
import com.example.inventaire.Model.Egg;
import com.example.inventaire.Service.InventaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
public class InventaireController {
    @Autowired
    private InventaireService inventaireService;
    @PostMapping("/add_pokemon_to_inventaire")
    public @ResponseBody Pokemon addPokemon(
            @RequestParam Integer level,
            @RequestParam String name) {
        final Pokemon pokemon = new Pokemon();
        pokemon.setName(name);
        pokemon.setLevel(level);
        return inventaireService.savePokemon(pokemon);
    }
    @PostMapping("/add_egg_to_inventaire")
    public @ResponseBody Egg addEgg(
            @RequestParam Integer hatchingTime,
            @RequestParam String name) {
        final Egg egg = new Egg();
        egg.setName(name);
        egg.setHatchingTime(hatchingTime);
        return inventaireService.saveEgg(egg);
    }
    // @GetMapping("/inventaire")
    // public @ResponseBody Iterable<Inventaire> getAllInventaire() {
        // This returns a JSON or XML with the users
        // return inventaireService.getAllInventaire();
    // }
}

    //@PostMapping("/eggs/")


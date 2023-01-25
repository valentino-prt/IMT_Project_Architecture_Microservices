package com.example.inventaire.web.Controller;

import com.example.inventaire.web.Model.Pokemon;
import com.example.inventaire.web.Model.Egg;
import com.example.inventaire.web.Service.InventaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
public class InventaireController {
    @Autowired
    private InventaireService inventaireService;
    @PostMapping("/add_pokemon")
    public @ResponseBody Pokemon addPokemon(
            @RequestParam Integer level,
            @RequestParam String name) {
        final Pokemon pokemon = new Pokemon();
        pokemon.setName(name);
        pokemon.setLevel(level);
        return inventaireService.savePokemon(pokemon);
    }
    @PostMapping("/add_egg")
    public @ResponseBody Egg addEgg(
            @RequestParam Integer hatchingTime,
            @RequestParam String name) {
        final Egg egg = new Egg();
        egg.setName(name);
        egg.setHatchingTime(hatchingTime);
        return inventaireService.saveEgg(egg);
    }

    @GetMapping("/pokemons")
    public @ResponseBody Iterable<Pokemon> getAllPokemon() {
        // This returns a JSON or XML with the users
        return inventaireService.getAllPokemons();
    }

    @GetMapping("/eggs")
    public @ResponseBody Iterable<Egg> getAllEggs() {
        // This returns a JSON or XML with the users
        return inventaireService.getAllEggs();
    }

    @DeleteMapping("/delete_pokemon")
    public @ResponseBody String deletePokemon(
            @RequestParam Integer id) {
        // This returns a JSON or XML with the users
        inventaireService.deletePokemon(id);
        return "OK";
    }

    @DeleteMapping("/delete_egg")
    public @ResponseBody String deleteEgg(
            @RequestParam Integer id) {
        // This returns a JSON or XML with the users
        inventaireService.deleteEgg(id);
        return "OK";
    }
}


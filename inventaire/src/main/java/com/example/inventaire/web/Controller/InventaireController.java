package com.example.inventaire.web.Controller;

import com.example.inventaire.web.Model.Pokemon;
import com.example.inventaire.web.Model.Egg;
import com.example.inventaire.web.Service.InventaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController()
@CrossOrigin(origins = "*")
public class InventaireController {
    @Autowired
    private InventaireService inventaireService;

    @PostMapping("/addPokemon")
    public @ResponseBody Map<String, String> addPokemon(
            @RequestParam Integer level,
            @RequestParam String name,
            @RequestParam String no) {
        final Pokemon pokemon = new Pokemon();
        pokemon.setName(name);
        pokemon.setLevel(level);
        pokemon.setNo(no);
        return inventaireService.savePokemon(pokemon);
    }

    @PostMapping("/addEgg")
    public @ResponseBody Map<String, String> addEgg(
            @RequestParam Integer hatchingTime,
            @RequestParam String name,
            @RequestParam String no) {
        final Egg egg = new Egg();
        egg.setName(name);
        egg.setHatchingTime(hatchingTime);
        egg.setNo(no);
        return inventaireService.saveEgg(egg);
    }

    @GetMapping("/pokemons")
    public @ResponseBody Iterable<Pokemon> getAllPokemon() {
        return inventaireService.getAllPokemons();
    }

    @GetMapping("/eggs")
    public @ResponseBody Iterable<Egg> getAllEggs() {
        return inventaireService.getAllEggs();
    }

    @DeleteMapping("/deletePokemon")
    public @ResponseBody Map<String, String> deletePokemon(
            @RequestParam Integer id) {
        return inventaireService.deletePokemon(id);
    }

    @DeleteMapping("/deleteEgg")
    public @ResponseBody Map<String, String> deleteEgg(
            @RequestParam Integer id) {
        return inventaireService.deleteEgg(id);
    }
}


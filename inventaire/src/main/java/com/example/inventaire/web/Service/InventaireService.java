package com.example.inventaire.web.Service;

import com.example.inventaire.web.Model.Egg;
import com.example.inventaire.web.Model.Pokemon;
import com.example.inventaire.web.Repository.EggRepository;
import com.example.inventaire.web.Repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InventaireService {
    @Autowired
    private PokemonRepository pokemonRepository;
    @Autowired
    private EggRepository eggRepository;

    public Map<String, String> savePokemon(Pokemon pokemon) {
        pokemonRepository.save(pokemon);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Pokemon successfully added to inventory");
        return response;
    }

    public Map<String, String> saveEgg(Egg egg) {
        eggRepository.save(egg);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Egg successfully added to inventory");
        return response;
    }

    public List<Egg> getAllEggs() {
        return (List<Egg>) eggRepository.findAll();
    }

    public List<Pokemon> getAllPokemons() {
        return (List<Pokemon>) pokemonRepository.findAll();
    }

    public Map<String, String> deletePokemon(Integer id) {
        pokemonRepository.deleteById(id);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Pokemon deleted successfully from inventory");
        return response;
    }

    public Map<String, String> deleteEgg(Integer id) {
        eggRepository.deleteById(id);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Egg deleted successfully from inventory");
        return response;
    }

    public long countPokemon() {
        return pokemonRepository.count();
    }


}

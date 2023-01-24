package com.example.inventaire.Service;

import com.example.inventaire.Model.Egg;
import com.example.inventaire.Model.Pokemon;
import com.example.inventaire.Repository.EggRepository;
import com.example.inventaire.Repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InventaireService {
    @Autowired
    private PokemonRepository pokemonRepository;
    @Autowired
    private EggRepository eggRepository;

    public Pokemon savePokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Egg saveEgg(Egg egg) {
        return eggRepository.save(egg);
    }

    public List<Egg> getAllEggs() {
        return (List<Egg>) eggRepository.findAll();
    }

    public List<Pokemon> getAllPokemons() {
        return (List<Pokemon>) pokemonRepository.findAll();
    }

    public void deletePokemon(Integer id) {
        pokemonRepository.deleteById(id);
    }

    public void deleteEgg(Integer id) {
        eggRepository.deleteById(id);
    }

}

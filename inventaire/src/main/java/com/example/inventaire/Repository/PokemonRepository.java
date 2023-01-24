package com.example.inventaire.Repository;

import com.example.inventaire.Model.Pokemon;
import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {
}

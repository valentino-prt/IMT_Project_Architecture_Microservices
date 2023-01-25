package com.example.inventaire.web.Repository;

import com.example.inventaire.web.Model.Pokemon;
import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {
}

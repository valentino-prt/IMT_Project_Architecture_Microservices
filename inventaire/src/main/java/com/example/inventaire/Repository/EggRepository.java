package com.example.inventaire.Repository;

import com.example.inventaire.Model.Egg;
import org.springframework.data.repository.CrudRepository;

public interface EggRepository extends CrudRepository<Egg, Integer> {
}

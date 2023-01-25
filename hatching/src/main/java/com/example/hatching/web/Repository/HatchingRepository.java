package com.example.hatching.web.Repository;

import com.example.hatching.web.Model.Egg;
import org.springframework.data.repository.CrudRepository;

public interface HatchingRepository extends CrudRepository<Egg, Integer> {
}

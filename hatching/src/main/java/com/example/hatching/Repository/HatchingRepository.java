package com.example.hatching.Repository;

import com.example.hatching.Model.Eggs;
import org.springframework.data.repository.CrudRepository;

public interface HatchingRepository extends CrudRepository<Eggs, Integer> {

}

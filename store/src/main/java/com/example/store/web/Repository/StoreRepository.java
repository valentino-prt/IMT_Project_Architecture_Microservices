package com.example.store.web.Repository;
import com.example.store.web.model.Egg;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends CrudRepository<Egg, Integer> {
}

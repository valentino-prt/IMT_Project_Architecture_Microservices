package com.example.user.Repository;

import com.example.user.Model.Dresseur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface DresseurRepository extends CrudRepository<Dresseur, Integer> {

    public Dresseur findDresseurById(Integer id);
}
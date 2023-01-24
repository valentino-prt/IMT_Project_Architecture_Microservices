package com.example.hatching.Service;

import com.example.hatching.Model.Eggs;
import com.example.hatching.Repository.HatchingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HatchingService {
    @Autowired
    private HatchingRepository hatchingRepository;

    public Eggs save(Eggs egg) {
        return hatchingRepository.save(egg);
    }

    public List<Eggs> getAllUsers() {
        return (List<Eggs>) hatchingRepository.findAll();
    }
}

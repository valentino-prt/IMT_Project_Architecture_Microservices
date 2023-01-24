package com.example.hatching.Service;

import com.example.hatching.Model.Eggs;
import com.example.hatching.Repository.HatchingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.Date;
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

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        List<Eggs> oeuf = (List<Eggs>) hatchingRepository.findAll();

        for(Eggs egg : oeuf){
            int minute = egg.getDateDeposit().getMinutes();
            int newMinute = egg.getHatchingTime()/2 + minute;
            Date evolution = egg.getDateDeposit();
            evolution.setMinutes(newMinute);
            Date dateNow = new Date();
            System.out.println("l'oeuf" + egg.getName() + " doit éclore à : "+ evolution +" soit dans : " + (evolution.getTime() - dateNow.getTime()));
            if(evolution.getTime() <= dateNow.getTime())
            {
                System.out.println("oeuf éclos : " + egg.getName());
                hatchingRepository.delete(egg);
            }
        }
    }
}

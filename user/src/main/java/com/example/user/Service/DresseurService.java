package com.example.user.Service;

import com.example.user.Model.Dresseur;
import com.example.user.Repository.DresseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DresseurService {

    @Autowired
    private DresseurRepository dresserRepository;

    public Dresseur save(Dresseur dresseur) {
        return dresserRepository.save(dresseur);
    }

    public List<Dresseur> getAllUsers() {
        return (List<Dresseur>) dresserRepository.findAll();
    }

    public Optional<Dresseur> getDresseur(Integer id) {
        return dresserRepository.findById(id);
    }

    public void deleteDresseur(Integer id) {
        dresserRepository.deleteById(id);
    }

    public Map<String, String> addGold(Integer id, Integer amout) {
        Dresseur dresseur = dresserRepository.findDresseurById(id);
        dresseur.setGold(dresseur.getGold() + amout);
        dresserRepository.save(dresseur);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Money was successfully added.");

        return response;
    }

    public Map<String, String> removeGold(Integer id, Integer amout) {
        Dresseur dresseur = dresserRepository.findDresseurById(id);
        Map<String, String> response = new HashMap<>();

        if (dresseur.getGold() - amout < 0) {
            response.put("status", "failed");
            response.put("message", "Failed not enough money");

        } else {
            dresseur.setGold(dresseur.getGold() - amout);
            dresserRepository.save(dresseur);
            response.put("status", "success");
            response.put("message", "Money was successfully subtracted.");
        }
        return response;
    }

    public Map<String, String> addXp(Integer id, Integer amout) {
        Dresseur dresseur = dresserRepository.findDresseurById(id);
        dresseur.setXp(dresseur.getXp() + amout);
        dresserRepository.save(dresseur);

        Map<String, String> response = new HashMap<>();

        response.put("status", "success");
        response.put("message", "Xp was successfully added.");

        return response;
    }

    public Dresseur watchLevel(Integer id) {
        Dresseur dresseur = dresserRepository.findDresseurById(id);
        Integer xp = dresseur.getXp();
        Integer lvl = xp / 100;
        if (dresseur.getLevel() < lvl) {
            dresseur.setLevel(lvl);
            dresserRepository.save(dresseur);
        }
        return dresseur;
    }
}

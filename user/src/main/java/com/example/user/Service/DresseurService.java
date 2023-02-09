package com.example.user.Service;

import com.example.user.Model.Dresseur;
import com.example.user.Repository.DresseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Dresseur addGold(Integer id, Integer amout) {
        Dresseur dresseur = dresserRepository.findDresseurById(id);
        dresseur.setGold(dresseur.getGold() + amout);
        dresserRepository.save(dresseur);
        return dresseur;
    }

    public String removeGold(Integer id, Integer amout) {
        Dresseur dresseur = dresserRepository.findDresseurById(id);
        if (dresseur.getGold() - amout < 0) {
            return "Failed not enough money";
        }
        dresseur.setGold(dresseur.getGold() - amout);
        dresserRepository.save(dresseur);
        return "OK";
    }

    public Dresseur addXp(Integer id, Integer amout) {
        Dresseur dresseur = dresserRepository.findDresseurById(id);
        dresseur.setXp(dresseur.getXp() + amout);
        dresserRepository.save(dresseur);
        return dresseur;
    }
    public Dresseur watchLevel(Integer id){
        Dresseur dresseur = dresserRepository.findDresseurById(id);
        Integer xp = dresseur.getXp();
        Integer lvl = xp /100;
        if(dresseur.getLevel() < lvl){
            dresseur.setLevel(lvl);
            dresserRepository.save(dresseur);
        }
        return dresseur;
    }
}

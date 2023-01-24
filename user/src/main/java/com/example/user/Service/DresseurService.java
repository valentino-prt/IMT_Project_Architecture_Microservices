package com.example.user.Service;
import com.example.user.Model.Dresseur;
import com.example.user.Repository.DresseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void deleteDresseur(Integer id) {
        dresserRepository.deleteById(id);
    }

    /*public Dresseur changeGold(Integer id, Integer amout) {
        Dresseur dresseur = dresserRepository.findById(id);
        dresseur.setGold(dresseur.getGold() + amout);
        dresserRepository.save(dresseur);
        return dresseur;
    }*/
}

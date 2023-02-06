package com.example.user.Controller;

import com.example.user.Model.Dresseur;
import com.example.user.Service.DresseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@CrossOrigin(origins = "*")
public class DresseurController {

    @Autowired
    private DresseurService dresseurService;

    @PostMapping("/add_dresseur")
    public @ResponseBody Dresseur addDresseur(
            @RequestParam String name,
            @RequestParam Integer level,
            @RequestParam Integer gold,
            @RequestParam Integer xp) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        final Dresseur dresseur = new Dresseur();
        dresseur.setLevel(level);
        dresseur.setXp(xp);
        dresseur.setName(name);
        dresseur.setGold(gold);
        return dresseurService.save(dresseur);
    }

    @GetMapping("/dresseurs")
    public @ResponseBody Iterable<Dresseur> getAllUsers() {
        // This returns a JSON or XML with the users
        return dresseurService.getAllUsers();
    }

    @DeleteMapping("/dresseur")
    public @ResponseBody Optional<Dresseur> getDresseur(
            @RequestParam Integer id) {
        // This returns a JSON or XML with the users
        return dresseurService.getDresseur(id);
    }

    @DeleteMapping("/delete_dresseur")
    public @ResponseBody String deleteDresseur(
            @RequestParam Integer id) {
        // This returns a JSON or XML with the users
        dresseurService.deleteDresseur(id);
        return "OK";
    }

    @PutMapping("/add_gold")
    public @ResponseBody Dresseur addGold(
            @RequestParam Integer id,
            @RequestParam Integer amount) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return dresseurService.addGold(id, amount);
    }

    @PutMapping("/add_xp")
    public @ResponseBody Dresseur addXp(
            @RequestParam Integer id,
            @RequestParam Integer amount) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return dresseurService.addXp(id, amount);
    }

    @PutMapping("/remove_gold")
    public @ResponseBody Dresseur removeGold(
            @RequestParam Integer id,
            @RequestParam Integer amount) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return dresseurService.removeGold(id, amount);
    }

}

package com.example.user.Controller;

import com.example.user.Model.Dresseur;
import com.example.user.Service.DresseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController()
@CrossOrigin(origins = "*")
public class DresseurController {

    @Autowired
    private DresseurService dresseurService;

    @PostMapping("/addDresseur")
    public @ResponseBody Dresseur addDresseur(
            @RequestParam String name,
            @RequestParam Integer gold,
            @RequestParam Integer xp) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        final Dresseur dresseur = new Dresseur();
        dresseur.setXp(xp);
        dresseur.setName("Manny42");
        dresseur.setGold(gold);
        dresseur.setLevel(xp / 100);
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

    @DeleteMapping("/deleteDresseur")
    public @ResponseBody String deleteDresseur(
            @RequestParam Integer id) {
        // This returns a JSON or XML with the users
        dresseurService.deleteDresseur(id);
        return "OK";
    }

    @PutMapping("/addGold")
    public @ResponseBody Map<String, String> addGold(
            @RequestParam Integer id,
            @RequestParam Integer amount) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return dresseurService.addGold(id, amount);
    }

    @PutMapping("/addXp")
    public @ResponseBody  Map<String, String> addXp(
            @RequestParam Integer id,
            @RequestParam Integer amount) {
        var response = dresseurService.addXp(id, amount);
        dresseurService.watchLevel(id);
        return response;
    }

    @PutMapping("/removeGold")
    public @ResponseBody Map<String, String> removeGold(
            @RequestParam Integer id,
            @RequestParam Integer amount) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return dresseurService.removeGold(id, amount);
    }

}

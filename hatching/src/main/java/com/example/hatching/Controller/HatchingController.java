package com.example.hatching.Controller;

import com.example.hatching.Model.Eggs;
import org.springframework.web.bind.annotation.*;

@RestController
public class HatchingController {
    @PostMapping("/eggs")
    public Eggs addEggs (@RequestBody Eggs eggs)
    {
        System.out.println("nouveau oeuf :"+ eggs.getName()+"qui éclot dans :"+ eggs.getHatchingTime());
        return eggs;
    }
}

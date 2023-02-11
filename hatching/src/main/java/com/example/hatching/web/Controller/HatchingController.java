package com.example.hatching.web.Controller;

import com.example.hatching.queue.Sender;
import com.example.hatching.web.Model.Egg;
import com.example.hatching.web.Repository.HatchingRepository;
import com.example.hatching.web.Service.HatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController()
@CrossOrigin(origins = "*")
public class HatchingController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private HatchingRepository hatchingRepository;
    @Autowired
    private HatchingService hatchingService;

    @Autowired
    private Sender sender;

    @PostMapping("/addEgg")
    public @ResponseBody Egg addEggs(
            @RequestParam String name,
            @RequestParam Integer hatchingTime,
            @RequestParam String no) {
        final Egg egg = new Egg();
        egg.setName(name);
        egg.setHatchingTime(hatchingTime);
        Date date = new Date();
        egg.setDateDeposit(date);
        egg.setNo(no);
        return hatchingService.save(egg);
    }

    @GetMapping("/allEggs")
    public @ResponseBody Iterable<Egg> getAllEggs() {
        // This returns a JSON or XML with the users
        return hatchingService.getAllEggs();
    }

}


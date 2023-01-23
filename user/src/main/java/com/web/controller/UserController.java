package com.web.controller;

import com.web.model.UserTransaction;
import com.web.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping
    public UserTransaction save(@RequestBody UserTransaction userModelDetails) {
        return userRepo.save(userModelDetails);
    }

    @GetMapping
    public List<UserTransaction> getTransactions() {
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public UserTransaction findTransactionItemById(@PathVariable int id) {
        return userRepo.findItemById(id);
    }


    @DeleteMapping("/{id}")
    public String deleteTransactionById(@PathVariable int id)   {
        return userRepo.deleteUserModel(id);
    }
}
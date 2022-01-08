package com.SushiEmperor.SushiEmperor.controllers;

import com.SushiEmperor.SushiEmperor.entities.Users;
import com.SushiEmperor.SushiEmperor.repositories.UserRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepo;

    UserController(UserRepository userRepo){
        this.userRepo = userRepo;
    }
    @GetMapping("/fetch")
    public List<Users> getAllUsers(){
        return userRepo.findAll();
    }
}

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

    @GetMapping("/fetch/firstname")
    public List<Users> findUserByFirstName(String name){
        return userRepo.findAllByFirstName(name);
    }

    @GetMapping("/fetch/lastname")
    public List<Users> findUserByLastName(String name){
        return userRepo.findAllByLastName(name);
    }

    @GetMapping("/fetch/email")
    public List<Users> findUserByEmail(String email){
        return userRepo.findAllByEmail(email);
    }

    @GetMapping("/fetch/number")
    public List<Users> findUserByNumber(Long number){
        return userRepo.findAllByNumber(number);
    }
}

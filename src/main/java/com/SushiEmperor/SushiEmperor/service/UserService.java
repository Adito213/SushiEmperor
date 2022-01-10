package com.SushiEmperor.SushiEmperor.service;

import com.SushiEmperor.SushiEmperor.entities.Users;
import com.SushiEmperor.SushiEmperor.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public Users registerUser(String password, String email){
        if(email == null || password == null){
            return null;
        }else{
            Users user = new Users(email, password);
            return userRepo.save(user);
        }
    }

    public Users authenticate(String email, String password){
        return userRepo.findByEmailAndPassword(email,password).orElse(null);
    }
}

package com.SushiEmperor.SushiEmperor.service;

import com.SushiEmperor.SushiEmperor.model.Users;
import com.SushiEmperor.SushiEmperor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users registerUser(String email, String password){
        if(email == null || password == null){
            return null;
        }else{
            Users users = new Users();
            users.setEmail(email);
            users.setPassword(password);
            return userRepository.save(users);
        }
    }

    public Users authentication(String email, String password){
        return userRepository.findByEmailAndPassword(email, password).orElse(null);
    }

}

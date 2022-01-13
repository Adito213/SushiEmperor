package com.SushiEmperor.SushiEmperor.service;

import com.SushiEmperor.SushiEmperor.model.Users;
import com.SushiEmperor.SushiEmperor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users registerUser(String login, String email, String password){
        if(email == null || password == null){
            return null;
        }else{
            Users users = new Users();
            users.setLogin(login);
            users.setEmail(email);
            users.setPassword(password);
            return userRepository.save(users);
        }
    }

    public Users authentication(String email, String password){
        return userRepository.findByEmailAndPassword(email, password).orElse(null);
    }

    public boolean anotherUserUsingThisEmail(String email){
        if(userRepository.existsByEmail(email)){
            return true;
        }else{
            return false;
        }
    }

    public Users fillingData(String email, String firstName, String lastName, Integer num){
        Users user = userRepository.getByEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setNumber(num);
        return userRepository.save(user);
    }
}

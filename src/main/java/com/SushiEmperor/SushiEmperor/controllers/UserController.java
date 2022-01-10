package com.SushiEmperor.SushiEmperor.controllers;

import com.SushiEmperor.SushiEmperor.entities.Users;
import com.SushiEmperor.SushiEmperor.repositories.UserRepository;
import com.SushiEmperor.SushiEmperor.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// нещо не работи както трябва логина в този клип https://www.youtube.com/watch?v=x_nfnVU0wAI&ab_channel=JavaMaster всичко си бачка при мен ако
// го променя както е по клипа и е @RestController и заявката е @GetMapping ми принтира стринг с каквото ритърна а при него се отваря html страницата,
// това е временно решение докато видим защо става така
@RestController
public class UserController {
    private final UserRepository userRepo;
    private final UserService userServ;

    UserController(UserRepository userRepo, UserService userServ){
        this.userRepo = userRepo;
        this.userServ = userServ;
    }


//    @GetMapping("/register")
//    public String getRegisterPage(Model model){
//        model.addAttribute("registerRequest", new Users());
//        return "register_page";
//    }
//
//    @GetMapping("/login")
//    public String getLoginPage(Model model){
//        model.addAttribute("loginRequest", new Users());
//        return "login_page";
//    }
//
//    @PostMapping("/register")
//    public String register(@ModelAttribute Users users){
//        System.out.println("registerRequest:" + users);
//        Users registeredUser = userServ.registerUser(users.getPassword(), users.getEmail());
//        return registeredUser == null ? "error_page" : "redirect:/login";
//    }
//
//    @PostMapping("/login")
//    public String login(@ModelAttribute Users users,Model model){
//        System.out.println("loginRequest:" + users);
//        Users authenticatedUser = userServ.authenticate(users.getEmail(), users.getPassword());
//        if(authenticatedUser != null){
//            model.addAttribute("userLogin", authenticatedUser.getEmail());
//            return "personal_page.html";
//        }else{
//            return "error_page";
//        }
//    }


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

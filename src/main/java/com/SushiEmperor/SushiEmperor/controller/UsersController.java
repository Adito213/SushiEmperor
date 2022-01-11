package com.SushiEmperor.SushiEmperor.controller;

import com.SushiEmperor.SushiEmperor.model.Users;
import com.SushiEmperor.SushiEmperor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {


    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new Users());
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new Users());
        return "login_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Users users){
        System.out.println("register request: " + users);
        Users registeredUser = userService.registerUser(users.getEmail(), users.getPassword());
        if(userService.anotherUserUsingThisEmail(users.getEmail()) == false) {
            return registeredUser == null ? "error_page" : "redirect:/login";
        }else{
            return "used_email";
        }
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Users users, Model model){
        System.out.println("login request: " + users);
        Users authentication = userService.authentication(users.getEmail(), users.getPassword());
        if(authentication != null){
            model.addAttribute("userLogin", authentication.getLogin());
            return "personal_page";
        }else{
            return "error_page";
        }
    }
}

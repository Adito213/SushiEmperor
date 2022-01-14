package com.SushiEmperor.SushiEmperor.controller;

import com.SushiEmperor.SushiEmperor.controller.dto.UserRegistrationDto;
import com.SushiEmperor.SushiEmperor.service.UserInterface;
import com.SushiEmperor.SushiEmperor.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class UserRegistrationController {

    private UserInterface userInterface;

    public UserRegistrationController(UserInterface userInterface) {
        super();
        this.userInterface = userInterface;
    }

    @ModelAttribute("registerRequest")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "register_page";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("registerRequest") UserRegistrationDto registrationDto) {
        userInterface.save(registrationDto);
        return "redirect:/login";
    }
}

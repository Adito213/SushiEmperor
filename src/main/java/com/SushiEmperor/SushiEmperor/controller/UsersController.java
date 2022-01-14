package com.SushiEmperor.SushiEmperor.controller;

import com.SushiEmperor.SushiEmperor.model.Product;
import com.SushiEmperor.SushiEmperor.repository.UserRepository;
import com.SushiEmperor.SushiEmperor.service.ProductService;
import com.SushiEmperor.SushiEmperor.service.UserInterface;
import com.SushiEmperor.SushiEmperor.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {

    private final UserService userService;

    private final ProductService productService;

    private final UserInterface userInterface;

    private final UserRepository userRepository;
    public UsersController(UserService userService, ProductService productService, UserInterface userInterface, UserRepository userRepository) {
        this.userService = userService;
        this.productService = productService;
        this.userInterface = userInterface;
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login_page";
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "products";
    }
    @GetMapping("/admin")
    public String showAdminPanel() {
        return "admin";
    }
    @GetMapping("/users_list")
    public String showUserList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user_admin_view";
    }

}

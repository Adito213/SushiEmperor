package com.SushiEmperor.SushiEmperor.controller;

import com.SushiEmperor.SushiEmperor.service.ProductService;
import com.SushiEmperor.SushiEmperor.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {

    private final UserService userService;

    private final ProductService productService;

    public UsersController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
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

}

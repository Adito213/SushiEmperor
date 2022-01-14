package com.SushiEmperor.SushiEmperor.controller;

import com.SushiEmperor.SushiEmperor.model.Cart;
import com.SushiEmperor.SushiEmperor.model.Users;
import com.SushiEmperor.SushiEmperor.service.CartService;
import com.SushiEmperor.SushiEmperor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    @GetMapping("/cart")
    public String showShoppingCart(Model model, @AuthenticationPrincipal Authentication authentication){
        Users user = userService.getCurrentlyLoggedInUser(authentication);
        List<Cart> cartItems =  cartService.listCartItems(user);

        model.addAttribute("cartItems", cartItems);
        return "shopping_cart";
    }

}

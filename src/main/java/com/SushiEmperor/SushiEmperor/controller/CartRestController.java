package com.SushiEmperor.SushiEmperor.controller;


import com.SushiEmperor.SushiEmperor.model.Users;
import com.SushiEmperor.SushiEmperor.service.CartService;
import com.SushiEmperor.SushiEmperor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartRestController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @PostMapping("/cart/add/{pid}/{qty}")
    public String addProductToCart(@PathVariable("pid") Integer productId,
                                   @PathVariable("qty") Integer quantity,
                                   @AuthenticationPrincipal Authentication authentication){
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "You must login to add this product to your shopping cart.";
        }
        Users user = userService.getCurrentlyLoggedInUser(authentication);
        Integer addedQuantity =  cartService.addProduct(productId, quantity, user);

        return addedQuantity +  "product(s) were added";
    }
}

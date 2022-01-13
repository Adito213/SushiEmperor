package com.SushiEmperor.SushiEmperor.service;

import com.SushiEmperor.SushiEmperor.model.Users;
import com.SushiEmperor.SushiEmperor.repository.CartRepository;
import com.SushiEmperor.SushiEmperor.repository.ProductRepository;
import com.SushiEmperor.SushiEmperor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service

public class CartService implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    private UserRepository userRepository;
    private CartRepository cartRepository;

    public CartService(ProductRepository productRepository, UserRepository userRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //cartRepository.save(1,1);

    }

    //public void addProduct (Integer productId, Integer quantity, Integer userId) {
        //cartRepository.save(productRepository.getById(1).getId(),4, userRepository.getById(1).getId());

    //}
}

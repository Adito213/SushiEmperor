package com.SushiEmperor.SushiEmperor.service;

import com.SushiEmperor.SushiEmperor.model.Cart;
import com.SushiEmperor.SushiEmperor.model.Product;
import com.SushiEmperor.SushiEmperor.model.Users;
import com.SushiEmperor.SushiEmperor.repository.CartRepository;
import com.SushiEmperor.SushiEmperor.repository.ProductRepository;
import com.SushiEmperor.SushiEmperor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CartService implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    public CartService(ProductRepository productRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    public Integer addProduct(Integer productId, Integer quantity, Users user){
        Integer addedQuantity = quantity;

        Product product =  productRepository.getById(productId);

        Cart cart = cartRepository.findByUserAndProduct(user, product);

        if(cart != null){
            addedQuantity = cart.getQuantity() + quantity;
            cart.setQuantity(addedQuantity);
        }else{
            cart = new Cart();
            cart.setQuantity(quantity);
            cart.setUser(user);
            cart.setProduct(product);
        }

        cartRepository.save(cart);

        return addedQuantity;
    }

    public List<Cart> listCartItems(Users user){
        return cartRepository.findByUser(user);
    }

    @Override
    public void run(String... args) throws Exception {
        //cartRepository.save(1,1);

    }

    //public void addProduct (Integer productId, Integer quantity, Integer userId) {
        //cartRepository.save(productRepository.getById(1).getId(),4, userRepository.getById(1).getId());

    //}
}

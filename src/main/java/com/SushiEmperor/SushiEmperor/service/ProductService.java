package com.SushiEmperor.SushiEmperor.service;

import com.SushiEmperor.SushiEmperor.controller.dto.UserRegistrationDto;
import com.SushiEmperor.SushiEmperor.model.Product;
import com.SushiEmperor.SushiEmperor.model.Role;
import com.SushiEmperor.SushiEmperor.model.Users;
import com.SushiEmperor.SushiEmperor.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>(productRepository.findAll());
        return products;
    }

    public Product getProduct(Integer id) {
        return productRepository
                .findById(id)
                .orElse(null);
    }

    public boolean alreadyInDataBase(String name){
        if(productRepository.existsByName(name)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void run(String...args) throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Rice Roll", 23.00, "images/rice_roll.png"));
        products.add(new Product("Combo Husumaki", 50.00, "images/combo_husumaki.png"));
        for (Product product : products) {
            if(productRepository.existsByName(product.getName())){

            }else{
                productRepository.save(product);
            }
        }
    }

    public Product save(String name, Double price) {
        Product pr;
        if (name == null || price == null) {
            return null;
        } else {
            pr = new Product();
            pr.setName(name);
            pr.setPrice(price);
            pr.setPictureUrl("images/rice_roll.png");
        }
        return productRepository.save(pr);
    }
}

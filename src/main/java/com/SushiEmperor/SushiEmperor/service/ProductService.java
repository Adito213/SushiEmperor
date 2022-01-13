package com.SushiEmperor.SushiEmperor.service;

import com.SushiEmperor.SushiEmperor.model.Product;
import com.SushiEmperor.SushiEmperor.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        Product authenticateProduct = new Product("Rice Roll", 23.00, " /images/rice_roll.png");
        if(productRepository.existsByName(authenticateProduct.getName())){

        }else {
            productRepository.save(authenticateProduct);
        }
    }


}

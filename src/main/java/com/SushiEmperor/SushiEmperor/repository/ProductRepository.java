package com.SushiEmperor.SushiEmperor.repository;

import com.SushiEmperor.SushiEmperor.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    boolean existsByName(String name);
    Optional<Product> findById(Integer id);

    Product getById(Integer Id);
}

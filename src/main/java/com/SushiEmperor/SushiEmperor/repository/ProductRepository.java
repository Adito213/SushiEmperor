package com.SushiEmperor.SushiEmperor.repository;

import com.SushiEmperor.SushiEmperor.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    boolean existsByName(String name);
}

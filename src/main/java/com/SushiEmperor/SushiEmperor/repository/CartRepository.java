package com.SushiEmperor.SushiEmperor.repository;

import com.SushiEmperor.SushiEmperor.model.Cart;
import com.SushiEmperor.SushiEmperor.model.Product;
import com.SushiEmperor.SushiEmperor.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer>{
    //Optional<Cart> findAllByUserOrderByCreatedDateDesc(Users user);

    Optional<Cart> deleteByUser(Users user);
    List<Cart> findByUser(Users user);

    Cart findByUserAndProduct(Users user, Product product);

}

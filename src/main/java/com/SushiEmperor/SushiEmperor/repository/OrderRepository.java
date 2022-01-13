package com.SushiEmperor.SushiEmperor.repository;

import com.SushiEmperor.SushiEmperor.model.Cart;
import com.SushiEmperor.SushiEmperor.model.Order;
import com.SushiEmperor.SushiEmperor.model.Product;
import com.SushiEmperor.SushiEmperor.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer>{
    //Optional<Order> findAllByUserOrderByCreatedDateDesc(Users user);
}

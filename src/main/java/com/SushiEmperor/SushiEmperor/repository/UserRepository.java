package com.SushiEmperor.SushiEmperor.repository;

import com.SushiEmperor.SushiEmperor.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByEmailAndPassword(String email, String password);
}
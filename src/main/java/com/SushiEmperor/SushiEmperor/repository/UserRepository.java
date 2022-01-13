package com.SushiEmperor.SushiEmperor.repository;

import com.SushiEmperor.SushiEmperor.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByEmailAndPassword(String email, String password);
    Optional<Users> findByEmail(String email);
    boolean existsByEmail(String email);
    Users getByEmail(String email);
    Users getById (Integer id);
}

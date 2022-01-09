package com.SushiEmperor.SushiEmperor.repositories;

import com.SushiEmperor.SushiEmperor.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {
    List<Users> findAllByFirstName (String firstname);
    List<Users> findAllByLastName (String lastname);
    List<Users> findAllByEmail (String email);
    List<Users> findAllByNumber (Long num);

}

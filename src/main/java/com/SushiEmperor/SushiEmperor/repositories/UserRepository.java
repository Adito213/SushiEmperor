package com.SushiEmperor.SushiEmperor.repositories;

import com.SushiEmperor.SushiEmperor.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

}

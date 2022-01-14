package com.SushiEmperor.SushiEmperor.service;

import com.SushiEmperor.SushiEmperor.controller.dto.UserRegistrationDto;
import com.SushiEmperor.SushiEmperor.model.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserInterface extends UserDetailsService {
    Users save(UserRegistrationDto registrationDto);
}

package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto UserRegistrationDto);
}
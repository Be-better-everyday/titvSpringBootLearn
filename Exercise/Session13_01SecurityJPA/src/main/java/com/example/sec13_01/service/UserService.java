package com.example.sec13_01.service;

import com.example.sec13_01.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    /*  *Note* new Keyword: "UserDetailsService"*/

    public User findByUsername(String username);
}

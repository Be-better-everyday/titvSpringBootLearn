package com.example.s13_01jpa_security.service;

import com.example.s13_01jpa_security.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public interface UserService extends UserDetailsService {

    // this User in "springframework", It doesn't come from our project
    public User findByUserName(String username);
    public void save(User user);
}

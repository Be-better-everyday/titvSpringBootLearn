package com.example.studentmanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfiguration {
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails tung = User.withUsername("tung")
                .password("{noop}123456")
                .roles("teacher")
                .build();
        UserDetails quoc = User.withUsername("quoc")
                .password("{noop}quoc123456")
                .roles("manager")
                .build();
        UserDetails kiet = User.withUsername("kiet")
                .password("{noop}kiet123")
                .roles("admin")
                .build();
        return new InMemoryUserDetailsManager(tung, quoc, kiet);
    }
}

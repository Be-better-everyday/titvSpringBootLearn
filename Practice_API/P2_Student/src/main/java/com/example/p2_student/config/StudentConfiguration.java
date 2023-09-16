package com.example.p2_student.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.List;

@Configuration
public class StudentConfiguration {
//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
//        UserDetails dao = User.withUsername("dao")
//                .password("{noop}123456")
//                .roles("student")
//                .build();
//        UserDetails hoa = User.withUsername("hoa")
//                .password("{noop}hoa123")
//                .roles("teacher")
//                .build();
//        UserDetails admin = User.withUsername("admin")
//                .password("{noop}admin123")
//                .roles("admin")
//                .build();
//
//        return new InMemoryUserDetailsManager(dao, hoa, admin);
//    }
    @Bean
    @Autowired
    JdbcUserDetailsManager jdbcUserDetailsManager(DataSource data){
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(data);

        UserDetails userDetails = userDetailsManager.loadUserByUsername("nam");
        System.out.println(userDetails.getPassword());
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

        String authorizationRole = null;
        for (GrantedAuthority authority : authorities) {
            authorizationRole = authority.getAuthority();
            break;
        }
        System.out.println(authorizationRole);

        boolean userExists = userDetailsManager.userExists("nam");
        System.out.println("Is account \"nam\" existed: " + userExists);
        return userDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                config -> config
                        .requestMatchers(HttpMethod.GET,"/api/students/**").hasAnyRole("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers( HttpMethod.POST,"/api/students/**").hasAnyRole("ADMIN", "TEACHER")
                        .requestMatchers( HttpMethod.PUT,"/api/students/**").hasAnyRole("ADMIN", "TEACHER")
                        .requestMatchers(HttpMethod.DELETE,"/api/students/**").hasAnyRole("ADMIN")
//                        .anyRequest().permitAll()
//                        .anyRequest().authenticated()
        );
//        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();
    }
}

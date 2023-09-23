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
//        UserDetails dao = User.withUsername("dao1")
//                .password("{noop}dao1234")
//                .roles("STUDENT")
//                .build();
//        UserDetails hoa = User.withUsername("hoa1")
//                .password("{noop}hoa1234")
//                .roles("TEACHER")
//                .build();
//        UserDetails admin = User.withUsername("nam1")
//                .password("{noop}nam1234")
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(dao, hoa, admin);
//    }

    @Bean
    @Autowired
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource data){
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();
        userDetailsManager.setDataSource(data);

        return userDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                configurer->configurer
//                        .requestMatchers(HttpMethod.GET,"/api/students/**").hasAnyRole("ADMIN", "TEACHER", "STUDENT")
//                        .requestMatchers( HttpMethod.POST,"/api/students/**").hasAnyRole("ADMIN", "TEACHER")
//                        .requestMatchers( HttpMethod.PUT,"/api/students/**").hasAnyRole("ADMIN", "TEACHER")
//                        .requestMatchers("/**").hasAnyRole("ADMIN")
//                        .anyRequest().authenticated()
                        .requestMatchers(HttpMethod.GET, "api/students").hasAnyRole("TEACHER", "MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "api/students/**").hasAnyRole("TEACHER", "MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "api/students").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "api/students").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "api/students/**").hasRole("ADMIN")
        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();
    }
}

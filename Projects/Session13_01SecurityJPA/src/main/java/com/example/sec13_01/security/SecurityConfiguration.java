package com.example.sec13_01.security;

import com.example.sec13_01.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    // Nếu đã set method này thì không cần lưu {bcrypt} ở đầu password trong Database
    //==> Method này dùng trong method "authenticationProvider ()"


    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

/*    The "@Bean" annotation tells Spring Boot to create this bean when the application starts up.
    The "DaoAuthenticationProvider" class is a Spring Security class that implements the AuthenticationProvider interface.
    The "setUserDetailsService()" method sets the UserDetailsService bean that will be used to retrieve user information from the database.
    The "setPasswordEncoder()" method sets the PasswordEncoder bean that will be used to encode and decode passwords.
    The return statement returns the "DaoAuthenticationProvider" bean.    */

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
                configurer->configurer
                        .anyRequest().authenticated() // need authen to view
        ).formLogin(
                form->form.loginPage("/showLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()
        ).logout(
                logout->logout.permitAll()
        ).exceptionHandling(
                configurer->configurer.accessDeniedPage("/showPage403")
        );

        return http.build();
    }}

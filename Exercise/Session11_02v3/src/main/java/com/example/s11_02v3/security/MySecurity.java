package com.example.s11_02v3.security;

import com.example.s11_02v3.handler.CustomAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class MySecurity {
    private CustomAccessDeniedHandler customAccessDeniedHandler;
    @Autowired
    public MySecurity(CustomAccessDeniedHandler customAccessDeniedHandler) {
        this.customAccessDeniedHandler = customAccessDeniedHandler;
    }

//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
//        UserDetails dao = User.withUsername("dao")
//                .password("{noop}dao123")
//                .roles("ADMIN")
//                .build();
//        UserDetails hoa = User.withUsername("hoa")
//                .password("{noop}hoa123")
//                .roles("MANAGER")
//                .build();
//        UserDetails nam = User.withUsername("nam")
//                .password("{noop}nam123")
//                .roles("VIEWER")
//                .build();
//        return new InMemoryUserDetailsManager(dao, hoa, nam);
//    }

    @Bean
    @Autowired
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        /* --------------------10.2. Custom table user ------------*/
//        userDetailsManager.setUsersByUsernameQuery("SELECT id, pw, active FROM accounts WHERE id = ?");
//        userDetailsManager.setAuthoritiesByUsernameQuery("SELECT id, role FROM role WHERE id = ?");
        return userDetailsManager;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                config -> config
                        .requestMatchers("/static/**").permitAll()
                        .requestMatchers("students/student-form").hasAnyRole("ADMIN", "MANAGER")
                        .requestMatchers("students/add").hasAnyRole("ADMIN", "MANAGER")
                        .requestMatchers("students/update").hasAnyRole("ADMIN", "MANAGER")
                        .requestMatchers("students/delete").hasRole("ADMIN")
                        .requestMatchers("students/**").authenticated()
        ).formLogin(
                form -> form.loginPage("/students/showLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .defaultSuccessUrl("/students", true)
                        .permitAll()
        ).logout(
                logout -> logout.permitAll()
        ).exceptionHandling(
                config -> config.accessDeniedPage("/students/page403")
        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();
    }

}

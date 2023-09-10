package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class MySecurity {
    @Bean
    @Autowired
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

        /* ---------------------------10.2. Custom table user --------------------------*/
        userDetailsManager.setUsersByUsernameQuery("SELECT id, pw, active FROM accounts WHERE id = ?");
        userDetailsManager.setAuthoritiesByUsernameQuery("SELECT id, role FROM role WHERE id = ?");
        return userDetailsManager;
    }
    /*  *Note* Session 12.2 custom  */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                configurer->configurer.anyRequest().authenticated() // all request need login
        ).formLogin(
                form->form.loginPage("/showLoginPage")  // custom Endpoint for Login Page
                        .loginProcessingUrl("/authenticateTheUser") // "authenticateTheUser" is default page, we don't need to create him
                        .permitAll()    // this page don't need login to view
        ).logout(
                logout->logout.permitAll()  // permit everyone logout (*Note 12.4*)
        ).exceptionHandling(
//  custom page 403
                configurer->configurer.accessDeniedPage("/showPage403")
        )
        ;


//                        .requestMatchers(HttpMethod.GET, "api/students").hasAnyRole("TEACHER", "MANAGER", "ADMIN")
//                        .requestMatchers(HttpMethod.GET, "api/students/**").hasAnyRole("TEACHER", "MANAGER", "ADMIN")
//                        .requestMatchers(HttpMethod.POST, "api/students").hasAnyRole("MANAGER", "ADMIN")
//                        .requestMatchers(HttpMethod.PUT, "api/students").hasAnyRole("MANAGER", "ADMIN")
//                        .requestMatchers(HttpMethod.DELETE, "api/students/**").hasRole("ADMIN")
//        );


        // Chống giả mạo trạng thái ==> Đọc thêm
        http.csrf(csrf->csrf.disable());
        return http.build();
    }
}

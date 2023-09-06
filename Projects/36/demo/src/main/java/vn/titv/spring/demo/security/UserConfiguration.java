package vn.titv.spring.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class UserConfiguration {


    @Bean
    @Autowired
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

//        /* 10.2. Custom table user */
        userDetailsManager.setUsersByUsernameQuery("SELECT id, pw, active FROM accounts WHERE id = ?");
        userDetailsManager.setAuthoritiesByUsernameQuery("SELECT id, role FROM role WHERE id = ?");
        return userDetailsManager;
    }

    //    @Bean
    //    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
    //        UserDetails tung = User
    //                .withUsername("tung")
    //                .password("{noop}1234567")
    //                .roles("teacher")
    //                .build();
    //
    //        UserDetails quoc = User
    //                .withUsername("quoc")
    //                .password("{noop}quoc123")
    //                .roles("manager")
    //                .build();
    //
    //        UserDetails kiet = User
    //                .withUsername("kiet")
    //                .password("{noop}kiet123")
    //                .roles("admin")
    //                .build();
    //        return new InMemoryUserDetailsManager(tung, quoc, kiet);
    //    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
            http.authorizeHttpRequests(
                    configurer->configurer
                            .requestMatchers(HttpMethod.GET, "/api/students").hasAnyRole("TEACHER", "MANAGER", "ADMIN")
                            .requestMatchers(HttpMethod.GET, "/api/students/**").hasAnyRole("TEACHER", "MANAGER", "ADMIN")
                            .requestMatchers(HttpMethod.POST, "/api/students").hasAnyRole("MANAGER", "ADMIN")
                            .requestMatchers(HttpMethod.PUT, "/api/students").hasAnyRole("MANAGER", "ADMIN")
                            .requestMatchers(HttpMethod.DELETE, "/api/students/**").hasRole("ADMIN")
            );

            http.httpBasic(Customizer.withDefaults());

            http.csrf(csrf->csrf.disable());
            // csrf - cross site request forgery

            return http.build();
    }
}

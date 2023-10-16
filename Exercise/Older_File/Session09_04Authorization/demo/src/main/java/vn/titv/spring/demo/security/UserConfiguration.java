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

/* ------------- New code in Session 9.4 ---------- */
@Configuration
public class UserConfiguration {

//    @Bean
//    @Autowired
    /*dataSource is auto-created because we have been
    config datasource in application.properties
    * */
//    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
//        /*  this method create account from dataSource*/
//        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
////        userDetailsManager.setCreateUserSql(dataSource);
//        return userDetailsManager;
//    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails tung = User.withUsername("tung")
                .password("{noop}123456")
                .roles("TEACHER")
                .build();
        UserDetails quoc = User.withUsername("quoc")
                .password("{noop}quoc123456")
                .roles("MANAGER")
                .build();
        UserDetails kiet = User.withUsername("kiet")
                .password("{noop}kiet123")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(tung, quoc, kiet);
    }

    /* --------------- new in 9.4 ---------------- */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                configurer->configurer
                        .requestMatchers(HttpMethod.GET, "api/students").hasAnyRole("TEACHER", "MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "api/students/**").hasAnyRole("TEACHER", "MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "api/students").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "api/students").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "api/students/**").hasRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());

        // Chống giả mạo trạng thái ==> Đọc thêm
        http.csrf(csrf->csrf.disable());
        return http.build();
    }
}

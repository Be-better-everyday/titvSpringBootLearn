//package com.example.sec13_01.service;
//
//import com.example.sec13_01.dao.RoleRepository;
//import com.example.sec13_01.dao.UserRepository;
//import com.example.sec13_01.entity.Role;
//import com.example.sec13_01.entity.User;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class UserServiceImpl implements UserService{
//    private UserRepository userRepo;
//    private RoleRepository roleRepo;
//    @Autowired
//    public UserServiceImpl(UserRepository userRepo, RoleRepository roleRepo) {
//        this.userRepo = userRepo;
//        this.roleRepo = roleRepo;
//    }
//
//    @PostConstruct
//    public void insertUser(){
//        User user1 = new User();
//        user1.setUsername("tung");
//        user1.setPassword("$2a$12$cCd8pTRpWNauhONe2cFVoOs9YJ439UvSWdSbe.BQIYGh4NH.Sn6da");
//        user1.setEnabled(true);
//
//        Role role1 = new Role();
//        role1.setName("ROLE_ADMIN");
//        roleRepo.save(role1);
//
//        Collection<Role> roles = new ArrayList<>();
//        roles.add(role1);
//        user1.setRoles(roles);
//
//        userRepo.save(user1);
//    }
//
//    @Override
//    public User findByUsername(String username) {
//        return userRepo.findByUsername(username);
//    }
///*  *Note 13.1* The next 2 method is the most important method to using JPA in Spring Security*/
//    @Override
//    // This is default method to load User to use in Spring Security
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepo.findByUsername(username);
//        if(user == null){
//            throw new UsernameNotFoundException("Invalid Username or Password");
//        }
//        return new org.springframework.security.core.userdetails
//                .User(user.getUsername(), user.getPassword(), rolesToAuthorities(user.getRoles()));
//    }
//
//    /* *Note 13.1* this code will take all User's authorities ==> 52:00 in video*/
//    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Role> roles){
//        return roles.stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toList());
//    }
//
//}

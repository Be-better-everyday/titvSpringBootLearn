package com.example.s13_01jpa_security.service;

import com.example.s13_01jpa_security.dao.RoleRepository;
import com.example.s13_01jpa_security.dao.UserRepository;
import com.example.s13_01jpa_security.entity.Role;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.s13_01jpa_security.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void insertUser(){
        if(userRepository.findByUserName("dao") == null){
            User user1 = new User();
            user1.setUserName("dao");
            user1.setPassword("$2a$12$DM82MgeZNhD3Atuo9PEi8.aIyNGU/WtBZjX1wAv.dKHFv27omv0/6");
            user1.setEnabled(true);

            Role role1 = new Role();
            role1.setName("ROLE_ADMIN");

            Role role2 = new Role();
            role1.setName("ROLE_USER");
            roleRepository.save(role2);

            Collection<Role> roles = new ArrayList<>();
            roles.add(role1);
            user1.setRoles(roles);

            userRepository.save(user1);
        }
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password!");
        }
        /*  --- Convert to "springframework" User ---*/
        return new org.springframework.security.core.userdetails.User(
                user.getUserName(), user.getPassword(), rolesToAuthorities(user.getRoles()));
    }

    /* --- take Authorities for "springframework.security" "User" ---*/
    /* --- convert from roles to "springframework.security" Authorities --- */
    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}

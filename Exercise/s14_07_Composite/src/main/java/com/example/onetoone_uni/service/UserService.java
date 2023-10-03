package com.example.onetoone_uni.service;

import com.example.onetoone_uni.dao.UserRepo;
import com.example.onetoone_uni.entity.User;
import com.example.onetoone_uni.entity.UserId;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Data
public class UserService {
    private UserRepo userRepo;

//    @Autowired
//    public UserService(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }

    public User save(User user){
        return userRepo.save(user);
    }

    public User findById(UserId id){
        return userRepo.findById(id).orElse(null);
    }
    public User deleteByName(String firstName, String lastName){
//        userRepo.deleteUserByFirstNameAndLastName(firstName, lastName);
        return null;
    }
}

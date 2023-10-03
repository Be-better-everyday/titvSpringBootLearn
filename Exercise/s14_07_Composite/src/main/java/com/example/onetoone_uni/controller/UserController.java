package com.example.onetoone_uni.controller;

import com.example.onetoone_uni.dao.UserRepo;
import com.example.onetoone_uni.entity.User;
import com.example.onetoone_uni.entity.UserId;
import com.example.onetoone_uni.error.ApiError;
import com.example.onetoone_uni.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
//@NoArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody User user1){
        User savedUser = userService.findById(user1.getId());

        System.out.println(savedUser);
        if (savedUser == null) {
            System.out.println("1");
            userService.save(user1);
            // Return a ResponseEntity with a success status code (e.g., 201 Created)
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        } else {
            System.out.println("2");
            // Return a ResponseEntity with an error status code (e.g., 400 Bad Request)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiError.builder()
                    .message("Duplicate user! Please fill in another user!"));
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}


package com.example.demo.controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.service.UserService;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserApiController {
    private UserService service;
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody @Valid User user) {
        User persistedUser = service.add(user);
        UserDTO userDto = entity2Dto(persistedUser);

        URI uri = URI.create("/users/" + userDto.getId());

        return ResponseEntity.created(uri).body(userDto);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> get(@PathVariable("id") Long id) {
//        try {
//            User user = service.get(id);
//            return ResponseEntity.ok(entity2Dto(user));
//
//        } catch (UserNotFoundException e) {
//            e.printStackTrace();
//            return ResponseEntity.notFound().build();
//        }
//    }

    private UserDTO entity2Dto(User entity) {
        return modelMapper.map(entity, UserDTO.class);
    }

    private List<UserDTO> list2Dto(List<User> listUsers) {
        return listUsers.stream().map(
                        entity -> entity2Dto(entity))
                .collect(Collectors.toList());
    }
}

package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    @Autowired
    private UserRepository repo;

    public User add(User user) {
        return repo.save(user);
    }

    public User update(User user) throws UserNotFoundException {
        if (!repo.existsById(user.getId())) {
            throw new UserNotFoundException();
        }

        return repo.save(user);
    }

    public User get(Long id) throws UserNotFoundException {
        Optional<User> result = repo.findById(id);

        if (result.isPresent()) {
            return result.get();
        }

        throw new UserNotFoundException();
    }

    public List<User> list() {
        return (List<User>) repo.findAll();
    }

    public void delete(Long id) throws UserNotFoundException {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }

        throw new UserNotFoundException();
    }
}

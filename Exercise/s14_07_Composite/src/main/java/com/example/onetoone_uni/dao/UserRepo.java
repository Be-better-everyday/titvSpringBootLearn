package com.example.onetoone_uni.dao;

import com.example.onetoone_uni.entity.User;
import com.example.onetoone_uni.entity.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, UserId> {
//    public void deleteUserByFirstNameAndLastName(String firstName, String lastName);
}

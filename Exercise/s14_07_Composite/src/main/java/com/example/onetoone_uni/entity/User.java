package com.example.onetoone_uni.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user2")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @EmbeddedId
    UserId id;
    Integer age;
}


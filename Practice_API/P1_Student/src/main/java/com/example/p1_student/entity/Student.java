package com.example.p1_student.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "users_daonh")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name", length = 55)
    private String firstName;
    @Column(name = "last_name", length = 55)
    private String lastName;
    @Column(length = 55)
    private String email;
    @Column(length = 55)
    private String gender;
}

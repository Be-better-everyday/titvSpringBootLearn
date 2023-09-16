package com.example.p2_student.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.rest.core.annotation.RestResource;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "users_daonh")
@RestResource(exported = true)
public class Student2 {
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

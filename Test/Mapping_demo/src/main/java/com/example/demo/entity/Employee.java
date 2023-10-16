package com.example.demo.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Employee {
    private int id;
    private String name;
    private Division division;
    // getters and setters omitted
}

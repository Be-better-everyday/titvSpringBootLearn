package com.example.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ArticleDTO {
    private int id;
    private String name;
    private PersonDTO author;
}

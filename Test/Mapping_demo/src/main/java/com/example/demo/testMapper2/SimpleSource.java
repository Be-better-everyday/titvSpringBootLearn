package com.example.demo.testMapper2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "sources")
public class SimpleSource {
    @Id
    private Integer id;
    private String name;
    private String description;
    // getters and setters
}

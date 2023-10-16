package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SchoolDto {
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @Pattern(regexp = "^(\\d{10}|\\d{11}|\\d{12})$",
            message = "This phone number must include 10-12 number")
    private String phoneNumber;
}

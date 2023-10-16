package com.example.demo.dto;

import com.example.demo.entity.School;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TClassDto {
    private Integer id;
    @NotNull
    private Integer schoolId;
    @NotBlank
    private String className;
    @NotNull
    private Integer grade;
}

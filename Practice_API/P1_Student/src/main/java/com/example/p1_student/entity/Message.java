package com.example.p1_student.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public abstract class Message {
    private String message;
    private Student sender;
    private Student receiver;

    public abstract String sendMessage();
}

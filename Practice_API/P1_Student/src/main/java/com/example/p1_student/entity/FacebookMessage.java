package com.example.p1_student.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@SuperBuilder
@AllArgsConstructor
@Data
@ToString
@Component
//@Primary

public class FacebookMessage extends Message{
    private String methodName; // "inbox", "image"

    public FacebookMessage() {
        System.out.println("Constructor of class :" + getClass().getSimpleName());
    }

    @Override
    public String sendMessage() {
        return "Facebook sending";
//        return this.toString();
    }
}

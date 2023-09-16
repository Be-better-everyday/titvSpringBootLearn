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
//@NoArgsConstructor
@AllArgsConstructor
@Data
//@ToString
@Component
@Primary
@Scope
public class ZaloMessage extends Message{
    private String sendingType; // maybe "text" or "image"
    private static int i = 0;

    {
        i++;
        this.setSender(Student.builder()
                        .id(1)
                        .firstName("dao")
                        .lastName("nh")
                .build());
        this.sendingType = "text";
    }

    public ZaloMessage() {
        System.out.println("Constructor of class :" + getClass().getSimpleName());
        System.out.println(i + "th Element");
    }

    @Override
    public String sendMessage() {
        return this.toString();
//        return this.toString();
    }
    public String toString(){
        return super.toString() + "Sending type: " + this.sendingType;
    }
}

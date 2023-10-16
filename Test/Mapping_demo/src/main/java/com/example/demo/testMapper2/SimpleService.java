package com.example.demo.testMapper2;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class SimpleService {
    private SimpleRepository simpleRepository;
    public String concateStr(String str){
        return str + "123";
    }
}

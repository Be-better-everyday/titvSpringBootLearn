package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double add(double a, double b){
        System.out.println("Add: a + b = " + (a + b));
        return a + b;
    }
    
    public double substract(double a, double b){
        System.out.println("substract: a - b = " + (a - b));
        return a - b;
    }
    
    public double multiply(double a, double b){
        System.out.println("multiply: a * b = " + (a * b));
        return a * b;
    }
    
    public double divide(double a, double b){
//        b = Double.parseDouble("ba phay nam");
//        System.out.println("divide: a / b = " + (a / b));
        return a / b;
    }
}

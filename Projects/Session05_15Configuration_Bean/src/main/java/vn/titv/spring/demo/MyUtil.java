package vn.titv.spring.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.lang.*;

@Configuration
public class MyUtil {
    @Bean
    public Calculator getCalculator(){
        return new Calculator();
    }
}

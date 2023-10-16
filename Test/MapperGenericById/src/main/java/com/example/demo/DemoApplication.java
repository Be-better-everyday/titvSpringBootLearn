package com.example.demo;

import com.example.demo.dto.TClassDto;
import com.example.demo.entity.School;
import com.example.demo.entity.TClass;
import com.example.demo.mapper.ReferenceMapper;
import com.example.demo.mapper.SchoolMapper;
import com.example.demo.mapper.TClassMapper;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@AllArgsConstructor
public class DemoApplication {
    private ReferenceMapper referenceMapper;
    private SchoolMapper schoolMapper;
    private TClassMapper tClassMapper;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(){
        return runner -> {
            testReferenceMapper();

        };
    }

    private void testReferenceMapper() {
//        System.out.println(referenceMapper.map(2, School.class));
//        System.out.println(schoolMapper.toEntity(2));

        TClassDto tClassDto = TClassDto.builder()
                .id(1).schoolId(2).className("9A").grade(9)
                .build();

        TClass tClassMapperEntity = tClassMapper.toEntity(tClassDto);
        System.out.println(tClassMapperEntity);
        System.out.println("___***___");
        System.out.println(tClassMapperEntity.getSchool());
        System.out.println("___Convert back to Dto___");
        System.out.println(tClassMapper.toDto(tClassMapperEntity));
    }
}

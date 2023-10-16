package com.example.demo;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.SchoolDto;
import com.example.demo.entity.Division;
import com.example.demo.entity.Employee;
import com.example.demo.entity.School;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.mapper.ReferenceMapper;
//import com.example.demo.mapper.SchoolMapper;
import com.example.demo.testMapper2.SimpleDestination;
import com.example.demo.testMapper2.SimpleSource;
import com.example.demo.testMapper2.SimpleDestinationMapperUsingInjectedService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@AllArgsConstructor
public class DemoApplication {
    private ReferenceMapper referenceMapper;
//    private SchoolMapper schoolMapper;
    private SimpleDestinationMapperUsingInjectedService mapper;
    private EmployeeMapper employeeMapper;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(){
        return runner -> {
//            mapperTest();
//            testMapper2();
            testMapperWithObjectProperty();
        };
    }

    private void testMapperWithObjectProperty() {
        Division division = Division.builder().divisionName("Accounting").id(1)
                .build();

        Employee employee = Employee.builder()
                .id(1).division(division)
                .name("dao")
                .build();

        System.out.println(employeeMapper.employeeToEmployeeDTO(employee));
    }

    private void testMapper2() {
        SimpleSource source = SimpleSource.builder()
                .id(1).name("dao").description("this is test").build();
        SimpleDestination dto = mapper.sourceToDestination(source);
        System.out.println(dto);
        System.out.println("___***___");
        System.out.println(mapper.destinationToSource(dto));
        System.out.println("___***___");
    }

    private void mapperTest() {
//        School school = referenceMapper.map(1, School.class);
//        School school = schoolMapper.toEntity(1);
        System.out.println("___***___");
//        System.out.println(school);
    }
}

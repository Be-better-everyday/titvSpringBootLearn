package com.example.onetoone_uni;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@AllArgsConstructor(onConstructor = @__(@Autowired))
public class S1407OneToOneUniApplication {

    public static void main(String[] args) {
        SpringApplication.run(S1407OneToOneUniApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return runner -> {

        };

    }


}

package com.example.demo;

//import com.example.demo.mapper.SchoolMapper;
import com.example.demo.entity.Article;
import com.example.demo.entity.Person;
import com.example.demo.mapper.ArticleMapper;
import com.example.demo.mapper.ArticleUsingPersonMapper;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@AllArgsConstructor
public class DemoApplication {
    private ArticleMapper articleMapper;
    private ArticleUsingPersonMapper articleUsingPersonMapper;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(){
        return runner -> {
            Person author = Person.builder()
                    .id("1").name("Dao")
                    .build();

            Article article = Article.builder()
                    .id(2)
                    .name("The blue")
                    .author(author)
                    .build();

            System.out.println(articleMapper.articleToArticleDto(article));
            System.out.println("___Solution 2___");
            System.out.println(articleUsingPersonMapper.articleToArticleDto(article));
        };
    }

}

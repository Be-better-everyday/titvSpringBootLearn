package com.example.demo.config;

import com.example.demo.mapper.ArticleMapper;
import com.example.demo.mapper.ArticleUsingPersonMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Config {
    @Bean
    public ArticleMapper articleMapper(){
        return Mappers.getMapper(ArticleMapper.class);
    }

    @Bean
    public ArticleUsingPersonMapper articleUsingPersonMapper(){
        return Mappers.getMapper(ArticleUsingPersonMapper.class);
    }
}

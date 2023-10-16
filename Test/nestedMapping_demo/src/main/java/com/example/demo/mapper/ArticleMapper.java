package com.example.demo.mapper;

import com.example.demo.dto.ArticleDTO;
import com.example.demo.dto.PersonDTO;
import com.example.demo.entity.Article;
import com.example.demo.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleMapper {

    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

    ArticleDTO articleToArticleDto(Article article);
    default PersonDTO personToPersonDto(Person person) {
        return Mappers.getMapper(PersonMapper.class).personToPersonDTO(person);
    }
}

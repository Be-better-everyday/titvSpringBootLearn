package com.example.demo.mapper;

import com.example.demo.dto.ArticleDTO;
import com.example.demo.entity.Article;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = PersonMapper.class)
public interface ArticleUsingPersonMapper {
    ArticleUsingPersonMapper INSTANCE = Mappers.getMapper(ArticleUsingPersonMapper.class);
    ArticleDTO articleToArticleDto(Article article);
}

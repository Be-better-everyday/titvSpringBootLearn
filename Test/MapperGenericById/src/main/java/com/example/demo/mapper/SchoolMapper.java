package com.example.demo.mapper;

import com.example.demo.entity.School;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ReferenceMapper.class})
public interface SchoolMapper {

    School toEntity(Integer id);
}

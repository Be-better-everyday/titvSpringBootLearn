package com.example.demo.mapper;

import com.example.demo.dto.TClassDto;
import com.example.demo.entity.TClass;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {SchoolMapper.class})
public interface TClassMapper {
    @Mapping(target = "schoolId",
            expression = "java(tClass.getSchool().getId())")
    TClassDto toDto(TClass tClass);

    @Mapping(source = "schoolId", target = "school")
    TClass toEntity(TClassDto tClassDto);
}

//package com.example.demo.mapper;
//
//import com.example.demo.dto.SchoolDto;
//import com.example.demo.entity.School;
//import lombok.AllArgsConstructor;
//import org.mapstruct.*;
//import org.mapstruct.factory.Mappers;
//
//@Mapper(componentModel = "spring", uses = {ReferenceMapper.class})
//public interface SchoolMapper {
//    SchoolMapper INSTANCE = Mappers.getMapper(SchoolMapper.class);
//    School toEntity(Integer id);
//    SchoolDto fromSchool(School school);
//    School toSchool(SchoolDto schoolDto);
//
//    @Mapping(target = "id", ignore = true)
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void updateSchool(SchoolDto schoolDto, @MappingTarget School school);
//}
//
//

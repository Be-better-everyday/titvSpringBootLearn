package com.example.s11_02v3.converter;

import com.example.s11_02v3.entity.Gender;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

//@Converter(autoApply = true)
@Converter
public class GenderConverter implements AttributeConverter<Gender, String> {

    @Override
    public String convertToDatabaseColumn(Gender attribute) {
        if(attribute == null) return null;
        return attribute.getDatabaseValue();
    }

    @Override
    public Gender convertToEntityAttribute(String dbData) {
        if(dbData == null) return null;
        return Gender.fromDatabaseValue(dbData);
    }
}

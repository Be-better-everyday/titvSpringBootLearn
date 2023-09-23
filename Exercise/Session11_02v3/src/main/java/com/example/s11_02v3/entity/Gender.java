package com.example.s11_02v3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    NOT_FOUND("");

    private String databaseValue;

    Gender(String databaseValue) {
        this.databaseValue = databaseValue;
    }

    public String getDatabaseValue() {
        return databaseValue;
    }

    public static Gender fromDatabaseValue(String value) {
        for (Gender gender : Gender.values()) {
            if (gender.getDatabaseValue().equalsIgnoreCase(value)) {
                return gender;
            }
        }
        return Gender.NOT_FOUND;
//        throw new IllegalArgumentException("Invalid database value for Gender: " + value);
    }
}

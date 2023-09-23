package com.example.s11_02v3.entity;

import com.example.s11_02v3.converter.GenderConverter;
import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users_daonh")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name", length = 55)
    private String firstName;
    @Column(name = "last_name", length = 55)
    private String lastName;
    private String email;
    @Column(name = "gender")
//    private String genderStr;
//    @Enumerated(EnumType.STRING)
//    @Transient
    @Convert(converter = GenderConverter.class)
    private Gender gender;
//    private String gender;


//    @PostLoad
//    void fillTransient(){
//        if(!genderStr.equals("")){
//            this.gender = Gender.fromDatabaseValue(genderStr);
//        }else {
//            this.gender = Gender.NOT_FOUND;
//        }
//    }
//
//    @PrePersist
//    void fillPersistent(){
//        if(gender != null){
//            this.genderStr = gender.getDatabaseValue();
//        }
//    }

    public Student(Integer id, String firstName, String lastName, String email, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }
}

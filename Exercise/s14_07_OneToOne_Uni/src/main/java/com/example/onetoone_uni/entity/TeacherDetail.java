package com.example.onetoone_uni.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Blob;
import java.util.Date;

@Data@NoArgsConstructor
//@ToString
@Entity
@Table(name = "teacher_detail")
public class TeacherDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String identificationNumber;
    private Date dob;
    private String phoneNumber;
    private boolean gender;
    private String address;
    private double salary;
    @Column(name = "youtube_channel")
    private String youtubeChannel;
    private String facebook;
    private String hobby;
    @Lob
    private Blob avatar;
    @OneToOne(mappedBy = "teacherDetail", cascade = CascadeType.ALL)
    private Teacher teacher;

    @Override
    public String toString() {
        return "TeacherDetail{" +
                "id=" + id +
                ", identificationNumber='" + identificationNumber + '\'' +
                ", dob=" + dob +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", facebook='" + facebook + '\'' +
                ", hobby='" + hobby + '\'' +
                ", avatar=" + avatar +
                '}';
    }
}

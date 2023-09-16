package com.titv.spring.session07_5.entity;

public class Student {
    private int id;
    private String name;
    private int age;
    private String major;
    private double averagePoint;

    /* Jackson thông qua hàm Getter và Setter để convert giữa JSON và Java POJO */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getAveragePoint() {
        return averagePoint;
    }

    public void setAveragePoint(double averagePoint) {
        this.averagePoint = averagePoint;
    }

    public Student() {
    }

    public Student(int id, String name, int age, String major, double averagePoint) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.major = major;
        this.averagePoint = averagePoint;
    }
}

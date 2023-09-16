package com.example.session06_3hibernate_jpa.common;

import com.example.session06_3hibernate_jpa.dao.SinhVienDAOImpl;
import com.example.session06_3hibernate_jpa.entity.SinhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.Signature;
import java.util.Scanner;

@Configuration
public class MyConfiguration {
    @Bean  // Automatic run because annotation @Bean
    @Autowired
    public CommandLineRunner getRunner(SinhVienDAOImpl sinhVienDAOImpl){
        return runner -> {
            Scanner sc = new Scanner(System.in);
            System.out.println("Hello world");
            while(true){
                printMenu();
                int choose = sc.nextInt();
                sc.nextLine();
                if(choose == 1){
                    addNewStudent(sinhVienDAOImpl);
                }else if(choose == 2){
                    System.out.println("Enter id student to find: ");
                    int id = sc.nextInt(); sc.nextLine();
                    SinhVien sinhVien = sinhVienDAOImpl.getById(id);
                    if(sinhVien == null){
                        System.out.println("Not found!");
                    }else {
                        System.out.println(sinhVien);
                    }
                }
            }
        };
    }
    public void printMenu(){
        System.out.println("Menu: \n" +
                    "1. Add new student\n" +
                    "2. Find student\n" +
                    "3. Delete student\n" +
                    "Choose value: "
                );
    }

    public void addNewStudent(SinhVienDAOImpl sinhVienDAOImpl){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your First name:");
        String firstName = sc.nextLine();
        System.out.println("Enter your last name:");
        String lastName = sc.nextLine();
        System.out.println("Enter your email:");
        String email = sc.nextLine();
        sinhVienDAOImpl.save(new SinhVien(firstName, lastName, email));
    }
}

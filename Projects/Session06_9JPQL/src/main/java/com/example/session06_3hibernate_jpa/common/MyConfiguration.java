package com.example.session06_3hibernate_jpa.common;

import com.example.session06_3hibernate_jpa.dao.SinhVienDAO;
import com.example.session06_3hibernate_jpa.dao.SinhVienDAOImpl;
import com.example.session06_3hibernate_jpa.entity.SinhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.Signature;
import java.util.List;
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
                    findStudentById(sinhVienDAOImpl);
                }else if(choose == 3){
                    findStudentByName(sinhVienDAOImpl);
                }else if(choose == 4){
                    printAllStudent(sinhVienDAOImpl);
                }else if(choose == 5){
                    updateStudentById(sinhVienDAOImpl);
                }else if(choose == 6){
                    updateAllName(sinhVienDAOImpl);
                }else if(choose == 7){
                    removeById(sinhVienDAOImpl);
                }else if(choose == 8){
                    deleteByName(sinhVienDAOImpl);
                }
            }
        };
    }

    //___________---6.11 Delete Object
    private void deleteByName(SinhVienDAOImpl sinhVienDAOImpl) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the part of student's name you want to delete: ");
        String name = sc.nextLine();
        sinhVienDAOImpl.deleteByName(name);
    }

    private void removeById(SinhVienDAOImpl sinhVienDAOImpl) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the student's id you want to update information: ");
        int id = Integer.parseInt(sc.nextLine());
        sinhVienDAOImpl.deleteById(id);
    }

    //___________---6.10 Update Object
    private void updateAllName(SinhVienDAOImpl sinhVienDAOImpl) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your last name:");
        String lastName = sc.nextLine();
        System.out.printf("There are %d rows updated !", sinhVienDAOImpl.updateAllName(lastName));
    }

    private void updateStudentById(SinhVienDAOImpl sinhVienDAOImpl) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the student's id you want to update information: ");
        int id = Integer.parseInt(sc.nextLine());
        SinhVien sinhVien = sinhVienDAOImpl.getById(id);
        if(sinhVien == null){
            System.out.println("Can't found student you want to update");
        } else {
            System.out.println("Enter your First name:");
            String firstName = sc.nextLine();
            System.out.println("Enter your last name:");
            String lastName = sc.nextLine();
            System.out.println("Enter your email:");
            String email = sc.nextLine();
            sinhVien.setHoDem(firstName);
            sinhVien.setTen(lastName);
            sinhVien.setEmail(email);

            sinhVienDAOImpl.update(sinhVien);
        }
    }

    //___________---6.09 find Object
    public void findStudentById(SinhVienDAOImpl sinhVienDAOImpl){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student's id to find: ");
        int id = sc.nextInt(); sc.nextLine();
        SinhVien sinhVien = sinhVienDAOImpl.getById(id);
        if(sinhVien == null){
            System.out.println("Not found!");
        }else {
            System.out.println(sinhVien);
        }
    }

    public void findStudentByName(SinhVienDAOImpl sinhVienDAOImpl){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student's name to find: ");
        String name = sc.nextLine();
        List<SinhVien> sinhViens = sinhVienDAOImpl.getByName(name);
        if(sinhViens.size() == 0){
            System.out.println("No student matched!");
        }else {
            for(SinhVien s: sinhViens){
                System.out.println(s);
            }
        }
    }

    public void printAllStudent(SinhVienDAOImpl sinhVienDAOImpl){
        List<SinhVien> sinhViens = sinhVienDAOImpl.getAll();
        if(sinhViens.size() == 0){
            System.out.println("No student matched!");
        }else {
            for(SinhVien s: sinhViens){
                System.out.println(s);
            }
        }
    }
    public void printMenu(){
        System.out.println("Menu: \n" +
                    "1. Add new student\n" +
                    "2. Find student\n" +
                    "3. Find student by name\n" +
                    "4. Print all students\n" +
                        "5. Update Student depending on Id\n" +
                        "6. Update name of all Student\n" +
                        "7. Remove Student by Id\n" +
                        "8. Remove Student by name\n" +
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

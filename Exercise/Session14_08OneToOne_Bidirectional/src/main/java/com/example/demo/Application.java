package com.example.demo;

import com.example.demo.dao.TeacherDAO;
import com.example.demo.dao.TeacherDetailDAO;
import com.example.demo.dao.TeacherDetailDAOImpl;
import com.example.demo.entity.Teacher;
import com.example.demo.entity.TeacherDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
/*  Start Lesson at 15:00   */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(TeacherDAO teacherDAO, TeacherDetailDAO teacherDetailDAO){
        return runner -> {
//            createTeacher(teacherDAO);
//            Teacher teacherById = findTeacherById(teacherDAO, 1);
//            System.out.println(teacherById);
//            System.out.println("___");
//            System.out.println(teacherById.getTeacherDetail());

            TeacherDetail teacherDetail = teacherDetailDAO.findTeacherDetailById(7);
            System.out.println(teacherDetail);
            System.out.println(teacherDetail.getTeacher());
        };
    }

    private Teacher findTeacherById(TeacherDAO teacherDAO, int id) {
        return teacherDAO.findTeacherById(id);
    }

    public void createTeacher(TeacherDAO teacherDAO){
        Teacher teacher = new Teacher();
        teacher.setFirstName("Nhat Tung");
        teacher.setLastName("Le");
        teacher.setEmail("adsfas@gmail.com");

        TeacherDetail teacherDetail = new TeacherDetail();
        teacherDetail.setGender(true);
        teacherDetail.setAddress("Warsaw - Poland");
        teacherDetail.setYoutubeChannel("@TITVvn");

        teacher.setTeacherDetail(teacherDetail);
        teacherDetail.setTeacher(teacher);
        System.out.println("Saving teacher ..." + teacher);
        teacherDAO.save(teacher);
        System.out.println("Done");
    }
}

package com.example.onetoone_uni;

import com.example.onetoone_uni.dao.CourseDao;
import com.example.onetoone_uni.dao.StudentDao;
import com.example.onetoone_uni.dao.TeacherDao;
import com.example.onetoone_uni.dao.TeacherDetailDao;
import com.example.onetoone_uni.entity.Course;
import com.example.onetoone_uni.entity.Student;
import com.example.onetoone_uni.entity.Teacher;
import com.example.onetoone_uni.entity.TeacherDetail;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class S1407OneToOneUniApplication {
    private TeacherDao teacherDao;
    private TeacherDetailDao teacherDetailDao;
    private CourseDao courseDao;
    private StudentDao studentDao;

    public static void main(String[] args) {
        SpringApplication.run(S1407OneToOneUniApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return runner -> {
//            createCourses();

            createCoursesAndStudent();
        };
    }

    private void createCoursesAndStudent() {
        Teacher teacher = new Teacher();
        teacher.setFirstName("tung");
        teacher.setLastName("le");
        teacher.setEmail("tung@gmail.com");

        Teacher teacher2 = new Teacher();
        teacher2.setFirstName("tung2");
        teacher2.setLastName("le2");
        teacher2.setEmail("tung2@gmail.com");

        Student student1 = Student.builder()
                .firstName("dao")
                .lastName("nh")
                .email("dao@gmail.com")
                .gpa(2.7)
                .build();

        Student student2 = Student.builder()
                .firstName("dao2")
                .lastName("nh2")
                .email("dao2@gmail.com")
                .gpa(2.6)
                .build();

        teacher.addStudent(student1);teacher.addStudent(student2);
        student1.addTeacher(teacher);student1.addTeacher(teacher2);
        student2.addTeacher(teacher);student2.addTeacher(teacher2);

//        teacherDao.saveAll(teacher);
        teacherDao.save(teacher);
        System.out.println("________________________");
        teacherDao.save(teacher2);
        teacher2.addStudent(student1); teacher2.addStudent(student2);
        teacherDao.update(teacher2);
    }

    private void createCourses() {
        Teacher teacher = createTeacher();
        List<Course> courses = new ArrayList<>();

        Course course1 = Course.builder()
                .title("Spring and Hibernate")
                .desc("desc1")
                .build();
        Course course2 = Course.builder()
                .title("React")
                .desc("desc2")
                .build();
        courses.add(course1);
        courses.add(course2);
        courses.forEach(c -> c.setTeacher(teacher));

        teacher.setCourses(courses);
        System.out.println("Updating");
        teacherDao.update(teacher);
    }

    private Teacher findTeacherById(int i) {
        Teacher teacher = teacherDao.findTeacherById(i);
        System.out.println("Teacher: " + teacher);
        System.out.println("TeacherDetail: " + teacher.getTeacherDetail());
        return teacherDao.findTeacherById(i);
    }

    private Teacher createTeacher() {
        Teacher teacher = new Teacher();
        teacher.setFirstName("tung");
        teacher.setLastName("le");
        teacher.setEmail("tung@gmail.com");

        TeacherDetail teacherDetail = new TeacherDetail();
        teacherDetail.setGender(true);
        teacherDetail.setAddress("Poland");
        teacherDetail.setYoutubeChannel("@TITV");

        teacher.setTeacherDetail(teacherDetail);

        System.out.println("Saving teacher" + " " + teacher);
        teacherDao.save(teacher);
        System.out.println("Done !");

        return teacher;
    }
}

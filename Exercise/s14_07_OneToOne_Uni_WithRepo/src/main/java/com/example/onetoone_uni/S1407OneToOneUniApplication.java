package com.example.onetoone_uni;

import com.example.onetoone_uni.dao.TeacherDetailRepo;
import com.example.onetoone_uni.dao.TeacherRepo;
import com.example.onetoone_uni.dao.CourseRepo;
import com.example.onetoone_uni.dao.StudentRepo;
//import com.example.onetoone_uni.dao.TeacherDetailRepo;
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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class S1407OneToOneUniApplication {
    private TeacherRepo teacherRepo;
    private TeacherDetailRepo teacherDetailRepo;
    private CourseRepo courseRepo;
    private StudentRepo studentRepo;

    public static void main(String[] args) {
        SpringApplication.run(S1407OneToOneUniApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return runner -> {
//            createCourses();

//            createCoursesAndStudent();

//            saveOtherTeacher();

//            addStudentsToTeacher3();
//            updateTeacher3();

            addStudent3ToTeacher2();
        };

    }

    private void addStudent3ToTeacher2() {
        Student student3 = studentRepo.findById(1).orElse(null);
        System.out.println(student3);
        Teacher teacher2 = teacherRepo.findTeacherByIdJoinFetch(2);
        System.out.println(teacher2.getStudents());

    }

    private void updateTeacher3() {
        Student student3 = Student.builder()
                .firstName("Repo")
                .lastName("nh")
                .email("Repo@gmail.com")
                .gpa(2.7)
                .build();

        Teacher teacher3 = teacherRepo.findTeacherByIdJoinFetch(9);
        teacher3.addStudent(student3);
        teacherRepo.save(teacher3);
        System.out.println(teacher3.getStudents());
    }

    private void addStudentsToTeacher3() {
        Student student1 = studentRepo.findById(1).orElse(null);
        Student student2 = studentRepo.findById(2).orElse(null);

//        Teacher teacher3 = teacherRepo.findTeacherByIdJoinFetch(3);
//        Teacher teacher3 = teacherRepo.findById(3).orElse(null);

        Teacher teacher3 = new Teacher();
        teacher3.setFirstName("tung3");
        teacher3.setLastName("le3");
        teacher3.setEmail("tung3@gmail.com");
        if(teacher3 != null){
            teacher3.addStudent(student1);
            teacher3.addStudent(student2);
        }
        System.out.println(student1);
        System.out.println("________");
        System.out.println(student2);
        System.out.println("________");
        System.out.println(teacher3);
//        System.out.println(teacher3.getStudents());
        System.out.println("________");

        teacherRepo.save(teacher3);
    }

    private void saveOtherTeacher() {
        Student student1 = studentRepo.findById(1).orElse(null);
        Student student2 = studentRepo.findById(2).orElse(null);

        Teacher teacher = new Teacher();
        teacher.setFirstName("tung3");
        teacher.setLastName("le3");
        teacher.setEmail("tung3@gmail.com");

        teacherRepo.save(teacher);
//        teacher.addStudent(student1);
//        teacher.addStudent(student2);
//        teacherRepo.save(teacher);
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
                .firstName("Repo")
                .lastName("nh")
                .email("Repo@gmail.com")
                .gpa(2.7)
                .build();

        Student student2 = Student.builder()
                .firstName("Repo2")
                .lastName("nh2")
                .email("Repo2@gmail.com")
                .gpa(2.6)
                .build();

        teacher.addStudent(student1);
        teacher.addStudent(student2);
        teacher2.addStudent(student1);
        teacher2.addStudent(student2);

//        teacherRepo.saveAll(teacher);
        teacherRepo.saveAll(Arrays.asList(teacher, teacher2));
        System.out.println("________________________");
//        teacherRepo.save(teacher2);
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
        teacherRepo.save(teacher);
    }

    private Teacher findTeacherById(int i) {
        Teacher teacher = teacherRepo.findById(i).orElse(null);
        System.out.println("Teacher: " + teacher);
        System.out.println("TeacherDetail: " + teacher.getTeacherDetail());
        return teacher;
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
        teacherRepo.save(teacher);
        System.out.println("Done !");

        return teacher;
    }
}

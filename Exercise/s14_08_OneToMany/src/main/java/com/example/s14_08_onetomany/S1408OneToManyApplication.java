package com.example.s14_08_onetomany;

import com.example.s14_08_onetomany.dao.CourseDao;
import com.example.s14_08_onetomany.dao.TeacherDao;
import com.example.s14_08_onetomany.entity.Course;
import com.example.s14_08_onetomany.entity.Teacher;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//@AllArgsConstructor(onConstructor = @__(@Autowired))
public class S1408OneToManyApplication {
    private CourseDao courseDao;
    private TeacherDao teacherDao;
    @Autowired
    public S1408OneToManyApplication(CourseDao courseDao, TeacherDao teacherDao) {
        System.out.println(1);
        this.courseDao = courseDao;
        this.teacherDao = teacherDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(S1408OneToManyApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(){
        return runner -> {
            if (teacherDao.findTeacherById(1) == null) {
                createTeacherWithCourse();
            }
            Teacher teacherById = teacherDao.findTeacherByIdJoinFetch(1);
            System.out.println(teacherById);
            System.out.println("_____");
            System.out.println(teacherById.getCourses());

//            Course courseById = courseDao.findCourseById(1);
//            System.out.println(courseById);
//            System.out.println(courseById.getTeacher());
        };
    }

    private void createTeacherWithCourse() {
        Teacher teacher = Teacher.builder()
                .firstName("nam")
                .lastName("le minh")
                .email("nam@gmail.com")
                .build();
        Course course1 = Course.builder()
                .title("Spring and Hibernate")
                .desc("desc1")
                .build();
        Course course2 = Course.builder()
                .title("React")
                .desc("desc2")
                .build();
        List<Course> courses = new ArrayList<>();
        courses.add(course1); courses.add(course2);
        courses.forEach(c -> c.setTeacher(teacher));

        teacher.setCourses(courses);
        teacherDao.save(teacher);
    }
}

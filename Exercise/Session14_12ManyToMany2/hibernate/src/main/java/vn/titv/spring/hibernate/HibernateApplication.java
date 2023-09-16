package vn.titv.spring.hibernate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.titv.spring.hibernate.dao.CourseDAO;
import vn.titv.spring.hibernate.dao.StudentDAO;
import vn.titv.spring.hibernate.dao.TeacherDAO;
import vn.titv.spring.hibernate.dao.TeacherDetailDAO;
import vn.titv.spring.hibernate.entity.Course;
import vn.titv.spring.hibernate.entity.Student;
import vn.titv.spring.hibernate.entity.Teacher;
import vn.titv.spring.hibernate.entity.TeacherDetail;

import java.util.List;

@SpringBootApplication
public class HibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(TeacherDAO teacherDAO,
                                               TeacherDetailDAO teacherDetailDAO,
                                               CourseDAO courseDAO,
                                               StudentDAO studentDao
    ) {
        return runner -> {
            // createTeacher(teacherDAO);

            // findTeacherById(teacherDAO, 1);

//			findTeacherDetailById(teacherDetailDAO, 1);
//			createCourses(teacherDAO, courseDAO);

            /* _____EAGER____ ==> run with LAZY with throw a Error*/
//			findTeacherWithCourse(teacherDAO, 1);
//			findTeacherWithCourse(teacherDAO, 11);

            /*______LAZY____without JOIN FETCH____*/
//			findTeacherWithCourse_LAZY(teacherDAO, courseDAO, 1);
//			findTeacherWithCourse_LAZY(teacherDAO, courseDAO, 11);

            /*______LAZY____with JOIN FETCH____*/
//            findTeacherWithCourse_JoinFetch(teacherDAO, courseDAO, 1);
//            findTeacherWithCourse_JoinFetch(teacherDAO, courseDAO, 11);

            /*___ ManyToMany ___*/
//            createCoureseAndStudent(courseDAO, studentDao);

            /*___ ManyToMany 14.12 ___*/
            findCoursesAndStudent(courseDAO, 17);
        };
    }

    private void findCoursesAndStudent(CourseDAO courseDAO, int id) {
        Course course = courseDAO.findCourseAndStudentByCourseId(id);
        System.out.println(course);

        System.out.println("__________");
        System.out.println(course.getStudents());
    }

    private void createCoureseAndStudent(CourseDAO courseDAO, StudentDAO studentDao) {
        Course course1 = new Course();
        course1.setTitle("Lap trinh mang");

        Student student1 = new Student();
        student1.setFirstName("student1");
        student1.setLastName("Last1");

        Student student2 = new Student();
        student2.setFirstName("student2");
        student2.setLastName("Last2");

        //add Student to Cources
        course1.addStudent(student1);
        course1.addStudent(student2);

        courseDAO.save(course1);
    }

    private void findTeacherWithCourse_JoinFetch(TeacherDAO teacherDAO, CourseDAO courseDAO, int id) {
        Teacher teacher = teacherDAO.findTeacherByIdJoinFetch(id);
        System.out.println("Teacher Information: ");
        System.out.println(teacher);

        /*___ Remove when using JOIN FETCH ___*/
//        List<Course> courses = courseDAO.findCoursesByTeacherId(id); // new
//        teacher.setCourses(courses);    //new
        System.out.println("List of courses: ");
        System.out.println(teacher.getCourses());
        System.out.println("___________");
    }

    private void findTeacherWithCourse_LAZY(TeacherDAO teacherDAO, CourseDAO courseDAO, int id) {
        Teacher teacher = teacherDAO.findTeacherById(id);
        System.out.println("Teacher Information: ");
        System.out.println(teacher);

        List<Course> courses = courseDAO.findCoursesByTeacherId(id); // new
        teacher.setCourses(courses);    //new
        System.out.println("List of courses: ");
        System.out.println(teacher.getCourses());
        System.out.println("___________");
    }

    private void findTeacherWithCourse(TeacherDAO teacherDAO, int id) {
        Teacher teacher = teacherDAO.findTeacherById(id);
        System.out.println("Teacher Information: ");
        System.out.println(teacher);
        System.out.println("List of courses: ");
        System.out.println(teacher.getCourses());
        System.out.println("___________");
    }

    private void createCourses(TeacherDAO teacherDAO, CourseDAO courseDAO) {
        Teacher teacher = teacherDAO.findTeacherById(1);

        List<Course> courses = List.of(
                new Course("Spring Hibernate", "Desc", null, null),
                new Course("Spring Hibernate", "Desc", null, null)
        );
        teacher.setCourses(courses);
        System.out.printf("Updating ...");
        teacherDAO.updateTeacher(teacher);
        System.out.println("Done!");
    }

    private void findTeacherDetailById(TeacherDetailDAO teacherDetailDAO, int id) {
        TeacherDetail teacherDetail = teacherDetailDAO.findTeacherDetailById(id);
        System.out.println("TeacherDetail: " + teacherDetail);
        System.out.println("Teacher: " + teacherDetail.getTeacher());
    }

    private void findTeacherById(TeacherDAO teacherDAO, int id) {
        Teacher teacher = teacherDAO.findTeacherById(id);
        System.out.println("Teacher: " + teacher);
        System.out.println("TeacherDetail: " + teacher.getTeacherDetail());
    }


    private void createTeacher(TeacherDAO teacherDAO) {
        Teacher teacher = new Teacher();
        teacher.setFirstName("Nhat Tung");
        teacher.setLastName("Le");
        teacher.setEmail("lenhattung@gmail.com");

        TeacherDetail teacherDetail = new TeacherDetail();
        teacherDetail.setGender(true);
        teacherDetail.setAddress("Warsaw - Poland");
        teacherDetail.setYoutubeChannel("@TITVvn");

        // associate the object
        teacher.setTeacherDetail(teacherDetail);


        // save
        System.out.println("Saving teacher .... " + teacher);
        teacherDAO.save(teacher);
        System.out.println("Done!");
    }


}

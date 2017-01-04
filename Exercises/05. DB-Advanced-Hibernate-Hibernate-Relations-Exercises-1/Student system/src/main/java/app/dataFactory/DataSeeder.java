package app.dataFactory;

import app.domain.Course;
import app.domain.Homework;
import app.domain.Resource;
import app.domain.Student;
import app.domain.enums.ContentType;
import app.domain.enums.ResourceType;
import app.services.CourseService;
import app.services.HomeworkService;
import app.services.ResourceService;
import app.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Component
public class DataSeeder implements Seeder{

    private final CourseService courseService;

    private final HomeworkService homeworkService;

    private final ResourceService resourceService;

    private final StudentService studentService;

    @Autowired
    private DataSeeder(
            CourseService courseService,
            HomeworkService homeworkService,
            ResourceService resourceService,
            StudentService studentService) {
        this.courseService = courseService;
        this.homeworkService = homeworkService;
        this.resourceService = resourceService;
        this.studentService = studentService;
    }

    @Override
    public void seedData() {
        if (dataBaseIsNotEmpty()) {
            return;
        }

        List<Course> courses = this.seedCourses();
        List<Student> students = this.seedStudents(courses);
        this.seedResources(courses);
        this.seedHomework(courses, students);
    }

    private void seedHomework(List<Course> courses, List<Student> students) {
        Homework homework = new Homework();
        homework.setContent("Relations");
        homework.setContentType(ContentType.PDF);
        homework.setSubmissionDate(new Date());
        homework.setCourse(courses.get(0));
        homework.setStudent(students.get(0));
        this.homeworkService.save(homework);

        Homework homework2 = new Homework();
        homework2.setContent("Joins");
        homework2.setContentType(ContentType.ZIP);
        homework2.setSubmissionDate(new Date());
        homework2.setCourse(courses.get(1));
        homework2.setStudent(students.get(1));
        this.homeworkService.save(homework2);

        Homework homework3 = new Homework();
        homework3.setContent("Inserts");
        homework3.setContentType(ContentType.PDF);
        homework3.setSubmissionDate(new Date());
        homework3.setCourse(courses.get(2));
        homework3.setStudent(students.get(2));
        this.homeworkService.save(homework3);
    }

    private void seedResources(List<Course> courses) {

        Resource resource = new Resource();
        resource.setName("Lab Java");
        resource.setResourceType(ResourceType.DOCUMENT);
        resource.setUrl("url");
        resource.setCourse(courses.get(0));
        this.resourceService.save(resource);

        Resource resource2 = new Resource();
        resource2.setName("Lab C#");
        resource2.setResourceType(ResourceType.VIDEO);
        resource2.setUrl("url");
        resource2.setCourse(courses.get(1));
        this.resourceService.save(resource2);

        Resource resource3 = new Resource();
        resource3.setName("Lab Mongo DB");
        resource3.setResourceType(ResourceType.OTHER);
        resource3.setUrl("url");
        resource3.setCourse(courses.get(2));
        this.resourceService.save(resource3);
    }

    private List<Student> seedStudents(List<Course> courses) {
        List<Student> students = new ArrayList<>();

        Student student = new Student();
        student.setName("Ivan");
        student.setBirthday(new Date());
        student.setPhoneNumber("089896597864");
        student.setRegistrationDate(new Date());
        student.getCourses().add(courses.get(0));
        this.studentService.save(student);

        Student student2 = new Student();
        student2.setName("Pesho");
        student2.setBirthday(new Date());
        student2.setPhoneNumber("0898900097864");
        student2.setRegistrationDate(new Date());
        student2.getCourses().add(courses.get(1));
        this.studentService.save(student2);

        Student student3 = new Student();
        student3.setName("Gosho");
        student3.setBirthday(new Date());
        student3.setPhoneNumber("0898900097800");
        student3.setRegistrationDate(new Date());
        student3.getCourses().add(courses.get(2));
        this.studentService.save(student3);

        students.add(student);
        students.add(student2);
        students.add(student3);

        return Collections.unmodifiableList(students);
    }

    private List<Course> seedCourses() {
        List<Course> courses = new ArrayList<>();

        Course course1 = new Course("Java DB", "The best course", new Date(), new Date(), new BigDecimal("20") );
        Course course2 = new Course("C# DB", "Good course", new Date(), new Date(), new BigDecimal("30"));
        Course course3 = new Course("Mongo DB", "Nice course", new Date(), new Date(), new BigDecimal("50"));

        this.courseService.save(course1);
        this.courseService.save(course2);
        this.courseService.save(course3);

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);

        return Collections.unmodifiableList(courses);
    }

    private boolean dataBaseIsNotEmpty() {
        return this.studentService.count() > 0;
    }
}

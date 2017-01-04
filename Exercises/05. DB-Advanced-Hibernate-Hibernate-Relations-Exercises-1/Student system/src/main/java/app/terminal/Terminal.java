package app.terminal;

import app.dataFactory.Seeder;
import app.services.CourseService;
import app.services.HomeworkService;
import app.services.ResourceService;
import app.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner{

    @Autowired
    private CourseService courseService;

    @Autowired
    private HomeworkService homeworkService;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private Seeder seeder;

    @Override
    public void run(String... strings) throws Exception {
//        //2
//        this.seeder.seedData();
//
//        //3.1.
//        System.out.println(this.homeworkService.studentsAndTheirHomework());
//
//        //3.2.
//        System.out.println(this.courseService.getCoursesAndTheirResources());
//
//        //3.3.
//        System.out.println(this.courseService.coursesWithMoreThanFiveResources());
//
//        //3.4.
//        System.out.println(this.courseService.coursesAndStudents(new Date()));
//
//        //3.5
//        System.out.println(this.studentService.studentCoursesData());
    }
}
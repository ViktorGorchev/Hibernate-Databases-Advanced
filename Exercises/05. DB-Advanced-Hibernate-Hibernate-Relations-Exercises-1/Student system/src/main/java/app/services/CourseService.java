package app.services;

import app.domain.Course;

import java.util.Date;

public interface CourseService {
    void save(Course course);

    Iterable<Course> findAll();

    String getCoursesAndTheirResources();

    String coursesWithMoreThanFiveResources();

    String coursesAndStudents(Date data);
}

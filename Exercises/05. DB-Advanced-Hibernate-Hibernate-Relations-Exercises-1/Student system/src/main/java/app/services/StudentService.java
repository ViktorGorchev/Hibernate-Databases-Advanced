package app.services;

import app.domain.Student;

public interface StudentService {
    void save(Student student);

    Iterable<Student> findAll();

    Long count();

    String studentCoursesData();
}

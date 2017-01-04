package app.services;

import app.domain.Homework;

public interface HomeworkService {
    void save(Homework homework);

    Iterable<Homework> findAll();

    String studentsAndTheirHomework();
}

package app.dao;

import app.domain.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface HomeworkDao extends JpaRepository<Homework, Long>{

    @Query(value = "SELECT s.name, h.content, h.contentType FROM Homework AS h INNER JOIN h.student AS s")
    List<Object[]> getStudentsAndTheirHomework();
}

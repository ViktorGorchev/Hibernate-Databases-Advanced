package app.dao;

import app.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface StudentDao extends JpaRepository<Student, Long>{

    @Query(value =
                "SELECT " +
                    "s.name, " +
                    "COUNT(c.id) AS courses_count, " +
                    "SUM(c.price) AS total_price, " +
                    "AVG(c.price) " +
                "FROM Student AS s " +
                "LEFT JOIN s.courses AS c " +
                "GROUP BY s.id " +
                "ORDER BY  " +
                    "total_price DESC, " +
                    "courses_count DESC, " +
                    "s.name ASC "
    )
    List<Object[]> studentCoursesData();

}

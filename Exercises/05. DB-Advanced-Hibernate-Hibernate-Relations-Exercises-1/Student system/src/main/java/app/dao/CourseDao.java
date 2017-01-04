package app.dao;

import app.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CourseDao extends JpaRepository<Course, Long> {
    @Query(value =
            "SELECT c.name, c.description, r " +
            "FROM Course AS c " +
            "INNER JOIN c.resources AS r " +
            "ORDER BY c.startDate ASC, c.endDate DESC ")
    List<Object[]> getCoursesAndTheirResources();

   @Query(value =
            "SELECT c.name, COUNT(r) AS count_resources FROM Course AS c " +
            "INNER JOIN c.resources AS r " +
            "GROUP BY c.id " +
            "HAVING COUNT(r) > 5 " +
            "ORDER BY count_resources DESC, c.startDate DESC "
    )
    List<Object[]> coursesWithMoreThanFiveResources();

    @Query(value =
                    "SELECT " +
                        "c.name, " +
                        "c.startDate, " +
                        "c.endDate, " +
                        "TIMEDIFF(c.endDate, c.startDate) AS duration, " +
                        "COUNT(s.id) AS students_count " +
                    "FROM Course AS c INNER JOIN c.students AS s " +
                    "WHERE c.startDate < STR_TO_DATE( :sqlDate, '%Y-%m-%d %l:%i %p' ) " +
                    "GROUP BY c.id " +
                    "ORDER BY " +
                            "students_count DESC, " +
                            "TIMEDIFF(c.endDate, c.startDate) DESC "
    )
    List<Object[]> coursesAndStudents(@Param(value = "sqlDate") String sqlDate);
}


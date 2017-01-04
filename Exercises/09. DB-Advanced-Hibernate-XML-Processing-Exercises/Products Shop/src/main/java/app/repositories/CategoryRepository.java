package app.repositories;

import app.domain.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long>{

    @Query(value = "SELECT c.name, c.products.size, AVG(p.price), SUM(p.price) " +
            "FROM Category AS c " +
            "INNER JOIN c.products AS p " +
            "GROUP BY c.id ")
    List<Object[]> categoryStatus();
}

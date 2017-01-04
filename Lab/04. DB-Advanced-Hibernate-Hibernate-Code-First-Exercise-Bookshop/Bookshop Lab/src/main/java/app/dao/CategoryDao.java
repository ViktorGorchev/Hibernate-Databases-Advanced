package app.dao;

import app.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CategoryDao extends JpaRepository<Category, Long>{
    Category findById(Long id);

    List<Category> findAll();

    @Query(value = "SELECT COUNT(c) FROM Category AS c")
    Long countAll();
}

package app.dao;

import app.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AuthorDao extends JpaRepository<Author, Long>{
    Author findById(Long id);

    @Query(value = "SELECT a FROM Author AS a")
    List<Author> findAll();

    @Query(value = "SELECT COUNT(a) FROM Author AS a")
    Long countAll();

    @Query(value = "SELECT a FROM Author AS a WHERE concat(a.firstName, ' ', a.lastName) = :name")
    Author findAuthorByFullName(@Param(value = "name") String name);
}
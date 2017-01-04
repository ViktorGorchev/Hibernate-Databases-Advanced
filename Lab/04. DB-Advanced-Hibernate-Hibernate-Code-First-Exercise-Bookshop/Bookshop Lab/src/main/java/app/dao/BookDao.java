package app.dao;

import app.domain.Author;
import app.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface BookDao extends JpaRepository<Book, Long> {
    Book findById(Long id);

    @Query(value = "SELECT b FROM Book AS b")
    List<Book> findAll();

    @Query(value = "SELECT COUNT(b) FROM Book AS b")
    Long countAll();

    //Get all books from author George Powell, ordered by their release date (descending),
    // then by book title (ascending)

    @Query(value = "SELECT b FROM Book AS b WHERE b.author = :author ORDER BY b.releaseDate DESC, b.title ASC")
    List<Book> findByAuthor(@Param(value = "author") Author author);



}

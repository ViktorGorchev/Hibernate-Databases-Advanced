package app.sevice;

import app.domain.Author;

public interface AuthorService {
    void save(Author author);

    void delete(Author author);

    void delete(Long id);

    Author findAuthor(Long id);

    Iterable<Author> findAuthors();

    Long authorsCount();

    Author findAuthor(String name);
}

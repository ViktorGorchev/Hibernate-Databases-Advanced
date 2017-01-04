package app.sevice;

import app.domain.Author;
import app.domain.Book;

public interface BookService {
    void save(Book book);

    void delete(Book book);

    void delete(Long id);

    Book findBook(Long id);

    Iterable<Book> findBooks();

    Long booksCount();

    Iterable<Book> allBooksFromAuthor(Author author);
}

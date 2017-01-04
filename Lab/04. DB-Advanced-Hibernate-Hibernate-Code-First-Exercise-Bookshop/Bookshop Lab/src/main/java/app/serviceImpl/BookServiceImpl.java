package app.serviceImpl;

import app.dao.BookDao;
import app.domain.Author;
import app.domain.Book;
import app.sevice.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;

    @Override
    public void save(Book book) {
        this.bookDao.saveAndFlush(book);
    }

    @Override
    public void delete(Book book) {
        this.bookDao.delete(book);
    }

    @Override
    public void delete(Long id) {
        this.bookDao.delete(id);
    }

    @Override
    public Book findBook(Long id) {
        return this.bookDao.findById(id);
    }

    @Override
    public Iterable<Book> findBooks() {
        return this.bookDao.findAll();
    }

    @Override
    public Long booksCount() {
        return this.bookDao.countAll();
    }

    @Override
    public Iterable<Book> allBooksFromAuthor(Author author) {
        return this.bookDao.findByAuthor(author);
    }
}

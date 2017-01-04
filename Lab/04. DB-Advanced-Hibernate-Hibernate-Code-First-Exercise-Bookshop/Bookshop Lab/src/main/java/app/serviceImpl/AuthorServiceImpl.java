package app.serviceImpl;

import app.dao.AuthorDao;
import app.domain.Author;
import app.sevice.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorDao authorDao;

    @Override
    public void save(Author author) {
        this.authorDao.saveAndFlush(author);
    }

    @Override
    public void delete(Author author) {
        this.authorDao.delete(author);
    }

    @Override
    public void delete(Long id) {
        this.authorDao.delete(id);
    }

    @Override
    public Author findAuthor(Long id) {
        return this.authorDao.findById(id);
    }

    @Override
    public Iterable<Author> findAuthors() {
        return this.authorDao.findAll();
    }

    @Override
    public Long authorsCount() {
        return this.authorDao.countAll();
    }

    @Override
    public Author findAuthor(String name) {
        return this.authorDao.findAuthorByFullName(name);
    }
}

package app.serviceImpl;

import app.dao.CategoryDao;
import app.domain.Category;
import app.sevice.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public void save(Category category) {
        this.categoryDao.saveAndFlush(category);
    }

    @Override
    public void delete(Category category) {
        this.categoryDao.delete(category);
    }

    @Override
    public void delete(Long id) {
        this.categoryDao.delete(id);
    }

    @Override
    public Category findCategory(Long id) {
        return this.categoryDao.findById(id);
    }

    @Override
    public Iterable<Category> findCategory() {
        return this.categoryDao.findAll();
    }

    @Override
    public Long categoriesCount() {
        return this.categoryDao.countAll();
    }
}
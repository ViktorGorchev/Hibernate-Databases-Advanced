package app.servicesImpl;

import app.dao.ProductDao;
import app.domain.Product;
import app.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public void persist(Product product) {
        this.productDao.saveAndFlush(product);
    }
}

package app.servicesImpl;

import app.domain.dto.jsonImport.ProductJsonDto;
import app.domain.dto.jsonExport.ProductSellerDto;
import app.domain.models.Category;
import app.domain.models.Product;
import app.domain.models.User;
import app.parser.ModelParser;
import app.repositories.CategoryRepository;
import app.repositories.ProductRepository;
import app.repositories.UserRepository;
import app.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelParser modelParser;

    @Override
    public void create(ProductJsonDto productJsonDto) {
        Product product = this.modelParser.convert(productJsonDto, Product.class);
        User buyer = this.randomUser();
        if(buyer.getId() > 20 && buyer.getId() < 60){
            buyer = null;
        }

        product.setBuyer(buyer);
        product.setSeller(this.randomUser());
        product.getCategories().add(this.randomCategory());

        this.productRepository.saveAndFlush(product);
    }

    @Override
    public List<ProductSellerDto> findProductsInPriceRange(BigDecimal fromPrice, BigDecimal toPrice) {
        List<Product> products = this.productRepository.findProductsInPriceRange(fromPrice, toPrice);
        List<ProductSellerDto> productSellerDtos = this.modelParser.convert(products, ProductSellerDto.class);

        return productSellerDtos;
    }

    private User randomUser(){
        long randomId = ThreadLocalRandom.current().nextLong(1, this.userRepository.count() + 1);
        User randomUser = this.userRepository.findOne(randomId);

        return randomUser;
    }

    private Category randomCategory(){
        long randomId = ThreadLocalRandom.current().nextLong(1, this.categoryRepository.count() + 1);
        Category randomCategory = this.categoryRepository.findOne(randomId);

        return randomCategory;
    }
}

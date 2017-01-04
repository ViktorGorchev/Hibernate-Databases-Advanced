package app.terminal;

import app.domain.dto.jsonExport.CategoryStatusDto;
import app.domain.dto.jsonExport.ProductSellerDto;
import app.domain.dto.jsonExport.SellerDto;
import app.domain.dto.jsonExport.UserStatusDto;
import app.domain.dto.jsonImport.CategoryJsonDto;
import app.domain.dto.jsonImport.ProductJsonDto;
import app.domain.dto.jsonImport.UserJsonDto;
import app.parser.JsonParser;
import app.services.CategoryService;
import app.services.ProductService;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Component
public class Terminal implements CommandLineRunner{

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private JsonParser jsonParser;

    @Override
    public void run(String... strings) throws Exception {
        //2.
        this.seedData();

        //3.1
        List<ProductSellerDto> productSellerDtos =
                this.productService.findProductsInPriceRange(new BigDecimal("500"), new BigDecimal("1000"));
        this.jsonParser.exportJson(
                productSellerDtos, "src/main/resources/files/output/json/products-in-range.json");

        //3.2
        List<SellerDto> sellerDtos = this.userService.findWithMoreThanOneBuyer();
        this.jsonParser.exportJson(sellerDtos, "src/main/resources/files/output/json/users-sold-products.json");

        //3.3
        List<CategoryStatusDto> categoryStatusDtos = this.categoryService.categoryStatus();
        this.jsonParser.exportJson(
                categoryStatusDtos, "src/main/resources/files/output/json/categories-by-products.json");

        //3.4
        UserStatusDto userStatusDto = this.userService.usersWithProductsSold();
        this.jsonParser.exportJson(userStatusDto, "src/main/resources/files/output/json/users-and-products.json");

    }

    private void seedData() {
        this.seedUsers();
        this.seedCategories();
        this.seedProducts();
    }

    private void seedProducts() {
        ProductJsonDto[] productJsonDtos = null;
        try {
            productJsonDtos = this.jsonParser.importJson(ProductJsonDto[].class, "/files/input/json/products.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (ProductJsonDto productJsonDto : productJsonDtos) {
            this.productService.create(productJsonDto);
        }
    }

    private void seedUsers() {
        UserJsonDto[] userJsonDtos = null;
        try {
            userJsonDtos = this.jsonParser.importJson(UserJsonDto[].class, "/files/input/json/users.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (UserJsonDto userJsonDto : userJsonDtos) {
            this.userService.create(userJsonDto);
        }
    }

    private void seedCategories(){
        CategoryJsonDto[] categoryJsonDtos = null;
        try {
            categoryJsonDtos = this.jsonParser.importJson(CategoryJsonDto[].class, "/files/input/json/categories.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (CategoryJsonDto categoryJsonDto : categoryJsonDtos) {
            this.categoryService.create(categoryJsonDto);
        }
    }
}
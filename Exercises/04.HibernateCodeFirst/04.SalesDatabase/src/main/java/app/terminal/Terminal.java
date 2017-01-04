package app.terminal;

import app.domain.Customer;
import app.domain.Product;
import app.domain.Sale;
import app.domain.StoreLocation;
import app.services.CustomerService;
import app.services.ProductService;
import app.services.SaleService;
import app.services.StoreLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class Terminal  implements CommandLineRunner{

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private SaleService saleService;

    @Autowired
    private StoreLocationService storeLocationService;

    @Override
    public void run(String... strings) throws Exception {

        Customer pesho = new Customer("pesho", "pesho@abv.bg", "BG45678890");
        Product apple = new Product("red apple", 50.0, new BigDecimal("1.5"));
        StoreLocation appleStoreLocation = new StoreLocation("Sofia, Titiava str., 2");
        Sale appleSale = new Sale(apple, pesho, appleStoreLocation, new Date());

        this.customerService.persist(pesho);
        this.productService.persist(apple);
        this.storeLocationService.persist(appleStoreLocation);
        this.saleService.persist(appleSale);
    }
}

package app.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double  quantity;

    private BigDecimal price;

    @OneToMany
    @JoinColumn(name = "product_id")
    private Set<Sale> salesOfProduct;

    public Product() {
    }

    public Product(String name, Double quantity, BigDecimal price) {
        this.setName(name);
        this.setQuantity(quantity);
        this.setPrice(price);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Sale> getSalesOfProduct() {
        return this.salesOfProduct;
    }

    public void setSalesOfProduct(Set<Sale> salesOfProduct) {
        this.salesOfProduct = salesOfProduct;
    }
}
package app.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "storeLocation_id")
    private StoreLocation storeLocationId;

    private Date date;

    public Sale() {
    }

    public Sale(Product productId, Customer customerId, StoreLocation storeLocationId, Date date) {
        this.setProductId(productId);
        this.setCustomerId(customerId);
        this.setStoreLocationId(storeLocationId);
        this.setDate(date);
    }

    public Product getProductId() {
        return this.productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Customer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public StoreLocation getStoreLocationId() {
        return this.storeLocationId;
    }

    public void setStoreLocationId(StoreLocation storeLocationId) {
        this.storeLocationId = storeLocationId;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
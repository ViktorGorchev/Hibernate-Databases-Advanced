package app.domain.models;

import app.domain.models.enums.DiscountPercent;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "sales")
public class Sale implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Car car;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    private Integer discount;

    public Sale() {
    }

    public Long getId() {
        return this.id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getDiscount() {
        return this.discount;
    }

    public void setDiscount(Integer discount) {
        if(this.getCustomer().getYoungDriver()){
            this.discount = discount + DiscountPercent.FIVE.getValue();
        }

        this.discount = discount;
    }

    public BigDecimal getPriceWithDiscount(){
        return this.getCar().getCarPrice().multiply(new BigDecimal((this.getDiscount() / 100.0) + 1));
    }
}

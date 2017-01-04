package app.domain.models;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Date birthDate;

    private Boolean isYoungDriver;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Sale> sales;

    public Customer() {
        this.setSales(new HashSet<>());
    }

    public Long getId() {
        return this.id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getYoungDriver() {
        return this.isYoungDriver;
    }

    public void setYoungDriver(Boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public Set<Sale> getSales() {
        return this.sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }

    public BigDecimal getTotalMoneySpend(){
        BigDecimal totalMoneySpend = BigDecimal.ZERO;

        for (Sale sale : this.getSales()) {
            totalMoneySpend = totalMoneySpend.add(sale.getCar().getCarPrice());
        }

        return totalMoneySpend;
    }

    public Integer getBoughtCarsCount(){
        return this.getSales().size();
    }
}
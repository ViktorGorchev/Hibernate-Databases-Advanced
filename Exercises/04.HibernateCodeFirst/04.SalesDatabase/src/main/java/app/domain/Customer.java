package app.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String creditCardNumber;

    @OneToMany
    @JoinColumn(name = "customer_id")
    private Set<Sale> salesForCustomer;

    public Customer() {
    }

    public Customer(String name, String email, String creditCardNumber) {
        this.setName(name);
        this.setEmail(email);
        this.setCreditCardNumber(creditCardNumber);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCardNumber() {
        return this.creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Set<Sale> getSalesForCustomer() {
        return this.salesForCustomer;
    }

    public void setSalesForCustomer(Set<Sale> salesForCustomer) {
        this.salesForCustomer = salesForCustomer;
    }
}
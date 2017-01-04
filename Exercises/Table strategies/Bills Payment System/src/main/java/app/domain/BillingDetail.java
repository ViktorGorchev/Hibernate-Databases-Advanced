package app.domain;

import app.domain.Banks.BankAccount;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "billing_details ")
public class BillingDetail implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @OneToOne(cascade = CascadeType.ALL)
    private User owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billingDetail")
    private Set<CreditCard> creditCards;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billingDetail")
    private Set<BankAccount> bankAccounts;

    public BillingDetail() {
    }

    public Long getId() {
        return this.id;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getOwner() {
        return this.owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<CreditCard> getCreditCards() {
        return this.creditCards;
    }

    public void setCreditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public Set<BankAccount> getBankAccounts() {
        return this.bankAccounts;
    }

    public void setBankAccounts(Set<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}

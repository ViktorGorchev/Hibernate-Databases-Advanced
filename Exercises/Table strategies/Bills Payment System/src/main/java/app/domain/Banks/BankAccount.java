package app.domain.Banks;

import app.domain.BillingDetail;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bank_account")
////single table strategy DB
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)

//table per class strategy DB
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

//join table strategy DB
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BankAccount implements Serializable {

    @Id
    ////single table strategy DB
    //@GeneratedValue(strategy = GenerationType.IDENTITY)

    ////table per class strategy DB
    //@GeneratedValue(strategy = GenerationType.TABLE)

    //join table strategy DB
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bankName;

    private String name;

    private String swiftCode;

    @ManyToOne(cascade = CascadeType.ALL)
    private BillingDetail billingDetail;

    public BankAccount() {
    }

    public BankAccount(String bankName) {
        this.bankName = bankName;
    }

    public Long getId() {
        return this.id;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSwiftCode() {
        return this.swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public BillingDetail getBillingDetail() {
        return this.billingDetail;
    }

    public void setBillingDetail(BillingDetail billingDetail) {
        this.billingDetail = billingDetail;
    }

}

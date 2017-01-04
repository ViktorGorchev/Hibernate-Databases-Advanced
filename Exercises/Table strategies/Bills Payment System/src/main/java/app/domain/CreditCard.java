package app.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "credit_cards")
public class CreditCard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardType;

    private Integer expirationMonth;

    private Integer expirationYear;

    @ManyToOne(cascade = CascadeType.ALL)
    private BillingDetail billingDetail;

    public CreditCard() {
    }

    public Long getId() {
        return this.id;
    }

    public String getCardType() {
        return this.cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Integer getExpirationMonth() {
        return this.expirationMonth;
    }

    public void setExpirationMonth(Integer expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public Integer getExpirationYear() {
        return this.expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }

    public BillingDetail getBillingDetail() {
        return this.billingDetail;
    }

    public void setBillingDetail(BillingDetail billingDetail) {
        this.billingDetail = billingDetail;
    }
}

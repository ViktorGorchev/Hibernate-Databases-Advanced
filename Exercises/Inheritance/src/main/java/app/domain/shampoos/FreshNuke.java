package app.domain.shampoos;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("fn")
public class FreshNuke extends BasicShampoo implements Serializable {

    private static final String BRAND = "Fresh Nuke";

    private static final BigDecimal PRICE = new BigDecimal("9.33");

    public FreshNuke() {
        super(BRAND, PRICE);
    }
}

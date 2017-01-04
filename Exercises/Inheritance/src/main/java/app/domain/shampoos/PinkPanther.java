package app.domain.shampoos;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("pp")
public class PinkPanther extends BasicShampoo implements Serializable {

    private static final String BRAND = "Pink Panther";

    private static final BigDecimal PRICE = new BigDecimal("8.50");

    public PinkPanther() {
        super(BRAND, PRICE);
    }
}

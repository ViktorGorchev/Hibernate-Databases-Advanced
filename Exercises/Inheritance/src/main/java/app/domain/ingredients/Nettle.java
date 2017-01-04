package app.domain.ingredients;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("nettle")
public class Nettle extends  BasicIngredient implements Serializable {

    private static final String NAME  = "Nettle";

    private static final BigDecimal PRICE = new BigDecimal("6.12");

    public Nettle() {
        super(NAME, PRICE);
    }
}

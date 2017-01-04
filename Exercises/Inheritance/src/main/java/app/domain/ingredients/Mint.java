package app.domain.ingredients;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "mint")
public class Mint extends BasicIngredient implements Serializable {

    private static final String NAME  = "Mint";

    private static final BigDecimal PRICE = new BigDecimal("3.54");

    public Mint() {
        super(NAME, PRICE);
    }
}

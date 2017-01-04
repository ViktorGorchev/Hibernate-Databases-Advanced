package app.domain.ingredients;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("ac")
public class AmmoniumChloride extends BasicChemicalIngredient implements Serializable {

    private static final String NAME  = "Ammonium Chloride";

    private static final BigDecimal PRICE = new BigDecimal("0.59");

    private static final String FORMULA  = "NH4Cl";

    public AmmoniumChloride() {
        super(NAME, PRICE, FORMULA);
    }
}

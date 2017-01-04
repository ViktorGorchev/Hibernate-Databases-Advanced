package app.domain.ingredients;

import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public abstract class BasicChemicalIngredient extends BasicIngredient implements ChemicalIngredient, Serializable {

    private String chemicalFormula;

    protected BasicChemicalIngredient() {
    }

    protected BasicChemicalIngredient(String name, BigDecimal price, String chemicalFormula) {
        super(name, price);
        this.setChemicalFormula(chemicalFormula);
    }

    @Override
    public String getChemicalFormula() {
        return this.chemicalFormula;
    }

    @Override
    public void setChemicalFormula(String chemicalFormula) {
        this.chemicalFormula = chemicalFormula;
    }
}

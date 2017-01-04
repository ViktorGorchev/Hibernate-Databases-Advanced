package app.domain.dto.ingrediantDtos;

import java.io.Serializable;
import java.math.BigDecimal;

public class BasicChemicalIngredientDto implements Serializable{

    private String name;

    private BigDecimal price;

    private String chemicalFormula;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getChemicalFormula() {
        return this.chemicalFormula;
    }

    public void setChemicalFormula(String chemicalFormula) {
        this.chemicalFormula = chemicalFormula;
    }

    @Override
    public String toString() {
        return "BasicChemicalIngredientDto{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", chemicalFormula='" + chemicalFormula + '\'' +
                '}';
    }
}

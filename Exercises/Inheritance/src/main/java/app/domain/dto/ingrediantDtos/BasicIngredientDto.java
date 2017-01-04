package app.domain.dto.ingrediantDtos;


import java.io.Serializable;
import java.math.BigDecimal;

public class BasicIngredientDto implements Serializable {

    private String name;

    private BigDecimal price;

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

    @Override
    public String toString() {
        return "BasicIngredientDto{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

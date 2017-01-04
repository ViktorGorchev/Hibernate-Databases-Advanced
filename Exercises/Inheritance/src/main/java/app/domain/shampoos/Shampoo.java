package app.domain.shampoos;

import app.domain.ingredients.BasicIngredient;

import java.math.BigDecimal;
import java.util.Set;

public interface Shampoo {
    long getId();

    void setId(long id);

    String getBrand();

    void setBrand(String brand);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    Set<BasicIngredient> getIngredients();

    void setIngredients(Set<BasicIngredient> ingredients);
}

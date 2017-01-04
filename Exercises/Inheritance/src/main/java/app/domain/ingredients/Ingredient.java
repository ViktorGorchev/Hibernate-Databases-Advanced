package app.domain.ingredients;

import app.domain.shampoos.BasicShampoo;

import java.math.BigDecimal;
import java.util.Set;

public interface Ingredient {

    long getId();

    void setId(long id);

    String getName();

    void setName(String name);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    Set<BasicShampoo> getShampoos();

    void setShampoos(Set<BasicShampoo> shampoos);
}

package app.domain.ingredients;


import app.domain.shampoos.BasicShampoo;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ingredients")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class BasicIngredient implements Ingredient, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private BigDecimal price;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "ingredients")
    private Set<BasicShampoo> shampoos;

    protected BasicIngredient() {
        this.setShampoos(new HashSet<>());
    }

    protected BasicIngredient(String name, BigDecimal price) {
        this();
        this.setName(name);
        this.setPrice(price);
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<BasicShampoo> getShampoos() {
        return this.shampoos;
    }

    public void setShampoos(Set<BasicShampoo> shampoos) {
        this.shampoos = shampoos;
    }
}
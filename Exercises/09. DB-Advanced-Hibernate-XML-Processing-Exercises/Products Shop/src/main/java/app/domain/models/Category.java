package app.domain.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category implements Serializable{

    private static final Integer NAME_MIN_LENGTH  = 3;

    private static final Integer NAME_MAX_LENGTH  = 15;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "categories")
    private Set<Product> products;

    public Category() {
        this.setProducts(new HashSet<>());
    }

    public Long getId() {
        return this.id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH){
            throw new IllegalAccessError("Name length must be minimum " + NAME_MIN_LENGTH + " and " + NAME_MAX_LENGTH);
        }

        this.name = name;
    }

    public Set<Product> getProducts() {
        return this.products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
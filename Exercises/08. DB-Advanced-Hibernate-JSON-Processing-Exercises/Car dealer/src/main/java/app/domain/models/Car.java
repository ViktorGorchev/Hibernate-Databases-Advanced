package app.domain.models;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String make;

    private String model;

    @Column(columnDefinition = "BIGINT")
    private BigInteger travelledDistance;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "parts_cars",
            joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id")
    )
    private Set<Part> parts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    private Set<Sale> sales;

    public Car() {
        this.setParts(new HashSet<>());
        this.setSales(new HashSet<>());
    }

    public Long getId() {
        return this.id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigInteger getTravelledDistance() {
        return this.travelledDistance;
    }

    public void setTravelledDistance(BigInteger travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public Set<Part> getParts() {
        return this.parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    public Set<Sale> getSales() {
        return this.sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }

    public BigDecimal getCarPrice(){
        BigDecimal price = BigDecimal.ZERO;
        for (Part part : this.getParts()) {
            price = price.add(part.getPrice());
        }

        return price;
    }
}

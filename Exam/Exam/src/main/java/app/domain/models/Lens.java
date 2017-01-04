package app.domain.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lenses")
public class Lens implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String make;

    private Integer focalLength;

    @Column(columnDefinition = "DOUBLE(16,1)")
    private Double maxAperture;

    private String compatibleWith;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Photographer owner;

    public Lens() {
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

    public Integer getFocalLength() {
        return this.focalLength;
    }

    public void setFocalLength(Integer focalLength) {
        this.focalLength = focalLength;
    }

    public Double getMaxAperture() {
        return this.maxAperture;
    }

    public void setMaxAperture(Double maxAperture) {
        this.maxAperture = maxAperture;
    }

    public String getCompatibleWith() {
        return this.compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public Photographer getOwner() {
        return this.owner;
    }

    public void setOwner(Photographer owner) {
        this.owner = owner;
    }
}

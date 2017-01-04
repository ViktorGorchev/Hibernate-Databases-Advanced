package app.domain.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "workshops")
public class Workshop implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @Column(columnDefinition = "DATETIME")
    private Date startDate;

    @Column(columnDefinition = "DATETIME")
    private Date endDate;

    @NotNull
    private String location;

    @NotNull
    private BigDecimal price;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Photographer trainer;

    @ManyToMany(mappedBy = "participatingInWorkshops", cascade = CascadeType.ALL)
    private Set<Photographer> participants;

    public Workshop() {
        this.setParticipants(new HashSet<>());
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
        this.name = name;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Photographer getTrainer() {
        return this.trainer;
    }

    public void setTrainer(Photographer trainer) {
        this.trainer = trainer;
    }

    public Set<Photographer> getParticipants() {
        return this.participants;
    }

    public void setParticipants(Set<Photographer> participants) {
        this.participants = participants;
    }
}

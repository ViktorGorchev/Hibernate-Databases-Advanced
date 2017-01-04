package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "doctors")
public class Doctor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String speciality;

    @OneToMany
    @JoinColumn(name = "doctor")
    private Set<Visitation> visitations;

    public Doctor() {
    }

    public Doctor(String name, String speciality) {
        this.setName(name);
        this.setSpeciality(speciality);
        this.setVisitations(visitations);
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return this.speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Set<Visitation> getVisitations() {
        return this.visitations;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }
}
package app.domain.models;

import app.domain.models.camera.BasicCamera;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "photographers")
public class Photographer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    @Size(min = 2, max = 50)
    private String lastName;

    @Pattern(regexp = "^[+]*\\d{1,3}\\/\\d{8,10}$")
    private String phone;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "primary_camera_id", referencedColumnName = "id")
    private BasicCamera primaryCamera;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "secondary_camera_id", referencedColumnName = "id")
    private BasicCamera secondaryCamera;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch = FetchType.EAGER)
    private Set<Lens> lenses;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Accessory> accessories;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainer")
    private Set<Workshop> trainingWorkshops;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "photographers_workshops",
            joinColumns = @JoinColumn(name = "photographer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "workshop_id", referencedColumnName = "id")
    )
    private Set<Workshop> participatingInWorkshops;

    public Photographer() {
        this.setLenses(new HashSet<>());
        this.setAccessories(new HashSet<>());
        this.setTrainingWorkshops(new HashSet<>());
        this.setParticipatingInWorkshops(new HashSet<>());
    }

    public Long getId() {
        return this.id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BasicCamera getPrimaryCamera() {
        return this.primaryCamera;
    }

    public void setPrimaryCamera(BasicCamera primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public BasicCamera getSecondaryCamera() {
        return this.secondaryCamera;
    }

    public void setSecondaryCamera(BasicCamera secondaryCamera) {
        this.secondaryCamera = secondaryCamera;
    }

    public Set<Lens> getLenses() {
        return this.lenses;
    }

    public void setLenses(Set<Lens> lenses) {
        this.lenses = lenses;
    }

    public Set<Accessory> getAccessories() {
        return this.accessories;
    }

    public void setAccessories(Set<Accessory> accessories) {
        this.accessories = accessories;
    }

    public Set<Workshop> getTrainingWorkshops() {
        return this.trainingWorkshops;
    }

    public void setTrainingWorkshops(Set<Workshop> trainingWorkshops) {
        this.trainingWorkshops = trainingWorkshops;
    }

    public Set<Workshop> getParticipatingInWorkshops() {
        return this.participatingInWorkshops;
    }

    public void setParticipatingInWorkshops(Set<Workshop> participatingInWorkshops) {
        this.participatingInWorkshops = participatingInWorkshops;
    }

    public String getFullName(){
        return this.getFirstName() + " " + this.getLastName();
    }
}

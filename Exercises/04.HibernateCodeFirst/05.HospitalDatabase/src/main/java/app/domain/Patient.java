package app.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String email;

    private Date dateOfBirth;

    @Column(columnDefinition = "LONGBLOB")
    private byte[] picture;

    @OneToMany
    @JoinColumn(name = "patient")
    private Set<Visitation> visitations;

    @OneToMany
    @JoinColumn(name = "patient")
    private Set<Diagnose> diagnoses;

    @OneToMany
    @JoinColumn(name = "patient")
    private Set<Medicament> prescribedMedicaments;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String address, String email, Date dateOfBirth, byte[] picture) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAddress(address);
        this.setEmail(email);
        this.setDateOfBirth(dateOfBirth);
        this.setPicture(picture);
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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public byte[] getPicture() {
        return this.picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}

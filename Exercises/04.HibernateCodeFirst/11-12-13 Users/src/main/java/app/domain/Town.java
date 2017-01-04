package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    @OneToMany
    @JoinColumn(name = "born_in_town")
    private Set<User> usersBornInTown;

    @OneToMany
    @JoinColumn(name = "currently_living_in_town")
    private Set<User> usersCurrentlyLivingInTown;

    public Town() {
    }

    public Town(String name, String country) {
        this.setName(name);
        this.setCountry(country);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<User> getUsersBornInTown() {
        return this.usersBornInTown;
    }

    public void setUsersBornInTown(Set<User> usersBornInTown) {
        this.usersBornInTown = usersBornInTown;
    }

    public Set<User> getUsersCurrentlyLivingInTown() {
        return this.usersCurrentlyLivingInTown;
    }

    public void setUsersCurrentlyLivingInTown(Set<User> usersCurrentlyLivingInTown) {
        this.usersCurrentlyLivingInTown = usersCurrentlyLivingInTown;
    }
}
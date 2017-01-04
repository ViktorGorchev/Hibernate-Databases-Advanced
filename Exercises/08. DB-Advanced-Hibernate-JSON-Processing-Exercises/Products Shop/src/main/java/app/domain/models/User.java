package app.domain.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable{

    private static final Integer LAST_NAME_MIN_LENGTH  = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private Integer age;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seller")
    private Set<Product> productsSold;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buyer")
    private Set<Product> productsBought;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_friends",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id")
    )
    private Set<User> friends;

    public User() {
        this.setProductsSold(new HashSet<>());
        this.setProductsBought(new HashSet<>());
        this.setFriends(new HashSet<>());
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
        if(lastName.length() < LAST_NAME_MIN_LENGTH){
            throw new IllegalArgumentException("Last firstName must be minimum " + LAST_NAME_MIN_LENGTH);
        }

        this.lastName = lastName;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Product> getProductsSold() {
        return this.productsSold;
    }

    public void setProductsSold(Set<Product> productsSold) {
        this.productsSold = productsSold;
    }

    public Set<Product> getProductsBought() {
        return this.productsBought;
    }

    public void setProductsBought(Set<Product> productsBought) {
        this.productsBought = productsBought;
    }

    public Set<User> getFriends() {
        return this.friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public String getFullName(){
        return this.getFirstName() + " " + this.getLastName();
    }
}
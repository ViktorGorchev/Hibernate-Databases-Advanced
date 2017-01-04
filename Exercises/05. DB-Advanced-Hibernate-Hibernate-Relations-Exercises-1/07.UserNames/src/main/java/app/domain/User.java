package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "users")
public class User implements Serializable{

    private static final Integer MIN_AGE = 1;
    private static final Integer MAX_AGE = 120;

    private static final Integer MIN_USERNAME_LENGTH = 4;
    private static final Integer MAX_USERNAME_LENGTH = 30;

    private static final Integer MAX_PROFILE_PICTURE_SIZE = 1024*1024;

    private static final String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Transient
    private String fullName;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "profile_picture", columnDefinition = "LONGBLOB")
    private byte[] profilePicture;

    private Date registeredOn;

    private Date lastTimeLoggedIn;

    private Integer age;

    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name="born_in_town")
    private Town bornInTown;

    @ManyToOne
    @JoinColumn(name="currently_living_in_town")
    private Town currentlyLivingInTown;

    @ManyToMany
    @JoinTable(
            name = "users_friends",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id")
    )
    private Set<User> friends;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Album> albums;

    public User() {
        this.setFriends(new HashSet<>());
        this.setAlbums(new HashSet<>());
    }

    public User(
            String firstName,
            String lastName,
            String username,
            String password,
            String email,
            byte[] profilePicture,
            Date registeredOn,
            Date lastTimeLoggedIn,
            Integer age,
            Boolean isDeleted,
            Town bornInTown,
            Town currentlyLivingInTown) {
        this();
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setProfilePicture(profilePicture);
        this.setRegisteredOn(registeredOn);
        this.setLastTimeLoggedIn(lastTimeLoggedIn);
        this.setAge(age);
        this.setDeleted(isDeleted);
        this.setBornInTown(bornInTown);
        this.setCurrentlyLivingInTown(currentlyLivingInTown);
    }

    public Long getId() {
        return this.id;
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

    public String getFullName() {
        return this.fullName;
    }

    private void setFullName(String fullName) {
        this.fullName = this.getFirstName() + " " + this.getLastName();
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        if(username.length() < MIN_USERNAME_LENGTH || username.length() > MAX_USERNAME_LENGTH){
            throw new IllegalArgumentException("Invalid User Name");
        }

        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        if(!this.validatePattern(password, PASSWORD_PATTERN)){
            throw new IllegalArgumentException("Invalid Password");
        }

        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if(!this.validatePattern(email, EMAIL_PATTERN)){
            throw new IllegalArgumentException("Invalid Email");
        }

        this.email = email;
    }

    public byte[] getProfilePicture() {
        return this.profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        if(profilePicture.length > MAX_PROFILE_PICTURE_SIZE){
            throw new IllegalArgumentException("Profile Pic too big");
        }


        this.profilePicture = profilePicture;
    }

    public Date getRegisteredOn() {
        return this.registeredOn;
    }

    public void setRegisteredOn(Date registeredOn) {
        this.registeredOn = registeredOn;
    }

    public Date getLastTimeLoggedIn() {
        return this.lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(Date lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        if(age < MIN_AGE || age > MAX_AGE){
            throw new IllegalArgumentException("Invalid age!");
        }
        this.age = age;
    }

    public Boolean getDeleted() {
        return this.isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        this.isDeleted = deleted;
    }

    public Town getBornInTown() {
        return this.bornInTown;
    }

    public void setBornInTown(Town bornInTown) {
        this.bornInTown = bornInTown;
    }

    public Town getCurrentlyLivingInTown() {
        return this.currentlyLivingInTown;
    }

    public void setCurrentlyLivingInTown(Town currentlyLivingInTown) {
        this.currentlyLivingInTown = currentlyLivingInTown;
    }

    public Set<User> getFriends() {
        return this.friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public Set<Album> getAlbums() {
        return this.albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    private boolean validatePattern(String item, String pattern){
        Pattern patternValidator = Pattern.compile(pattern);
        Matcher matcher = patternValidator.matcher(item);
        if(matcher.find()){
            return true;
        }

        return false;
    }
}
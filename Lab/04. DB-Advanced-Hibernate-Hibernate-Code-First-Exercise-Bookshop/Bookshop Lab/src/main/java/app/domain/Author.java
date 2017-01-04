package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long id;

    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "author")

    private Set<Book> booksByAuthor;

    public Author() {
        this.booksByAuthor = new HashSet<>();
    }

    public Author(String firstName, String lastName) {
        this();
        this.setFirstName(firstName);
        this.setLastName(lastName);
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

    public Set<Book> getBooksByAuthor() {
        return this.booksByAuthor;
    }

    public void setBooksByAuthor(Set<Book> booksByAuthor) {
        this.booksByAuthor = booksByAuthor;
    }
}
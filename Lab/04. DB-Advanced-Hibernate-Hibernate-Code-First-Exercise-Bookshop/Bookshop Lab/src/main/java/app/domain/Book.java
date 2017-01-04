package app.domain;

import app.domain.enums.AgeRestriction;
import app.domain.enums.EditionType;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book implements Serializable{

    private static final Integer MIN_TITLE  = 1;

    private static final Integer MAX_TITLE  = 50;

    private static final Integer MAX_DESCRIPTION  = 1000;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(value = EnumType.STRING)
    private EditionType editionType;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer copies;

    private Date releaseDate;

    @ManyToOne
    private Author author;

    @Enumerated(value = EnumType.STRING)
    private AgeRestriction ageRestriction;

    @ManyToMany
    @JoinTable(
            name = "books_categories",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    )
    private Set<Category> booksByCategory;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "related_books",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "related_id")
    )
    private Set<Book> relatedBooks;

    public Book() {
        this.setBooksByCategory(new HashSet<>());
        this.setRelatedBooks(new HashSet<>());
    }

    public Book(String title,
                 String description,
                 EditionType editionType,
                 BigDecimal price,
                 Integer copies,
                 Date releaseDate,
                 Author author,
                 AgeRestriction ageRestriction) {
        this();
        this.setTitle(title);
        this.setDescription(description);
        this.setEditionType(editionType);
        this.setPrice(price);
        this.setCopies(copies);
        this.setReleaseDate(releaseDate);
        this.setAuthor(author);
        this.setAgeRestriction(ageRestriction);
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        if (title != null &&
            (title.length() < MIN_TITLE || title.length() > MAX_TITLE)) {
            throw new IllegalArgumentException("Title must be between " + MIN_TITLE + " and " + MAX_TITLE);
        }

        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        if (description != null && description.length() > MAX_DESCRIPTION) {
            throw new IllegalArgumentException("Description symbols can't exceed " + MAX_DESCRIPTION);
        }

        this.description = description;
    }

    public EditionType getEditionType() {
        return this.editionType;
    }

    public void setEditionType(EditionType editionType) {
        this.editionType = editionType;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCopies() {
        return this.copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public AgeRestriction getAgeRestriction() {
        return this.ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public Set<Category> getBooksByCategory() {
        return this.booksByCategory;
    }

    public void setBooksByCategory(Set<Category> booksByCategory) {
        this.booksByCategory = booksByCategory;
    }

    public Set<Book> getRelatedBooks() {
        return this.relatedBooks;
    }

    public void setRelatedBooks(Set<Book> relatedBooks) {
        this.relatedBooks = relatedBooks;
    }
}
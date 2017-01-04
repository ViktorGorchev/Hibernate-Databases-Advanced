package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    @OneToMany(mappedBy = "course")
    private Set<Resource> resources;

    @OneToMany(mappedBy = "course")
    private Set<Homework> homework;

    public Course() {
        this.setStudents(new HashSet<>());
        this.setResources(new HashSet<>());
        this.setHomework(new HashSet<>());
    }

    public Course(
            String name,
            String description,
            Date startDate,
            Date endDate,
            BigDecimal price) {
        this();
        this.setName(name);
        this.setDescription(description);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setPrice(price);
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Student> getStudents() {
        return this.students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Resource> getResources() {
        return this.resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }

    public Set<Homework> getHomework() {
        return this.homework;
    }

    public void setHomework(Set<Homework> homework) {
        this.homework = homework;
    }

    @Override
    public String toString() {
        StringBuilder course = new StringBuilder();
        course.append(" Id: " + getId() + System.lineSeparator());
        course.append(" Name: " + getName() + System.lineSeparator());
        course.append(" Description: " + getDescription() + System.lineSeparator());
        course.append(" StartDate: " + getStartDate() + System.lineSeparator());
        course.append(" EndDate: " + getEndDate() + System.lineSeparator());
        course.append(" Price: " + getPrice() + System.lineSeparator());

        return course.toString();
    }
}
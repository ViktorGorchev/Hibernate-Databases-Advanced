package app.domain;

import app.domain.enums.ResourceType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "resources")
public class Resource implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private ResourceType resourceType;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String url;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "resource")
    private Set<License> licenses;

    public Resource() {
        this.setLicenses(new HashSet<>());
    }

    public Resource(String name, ResourceType resourceType, String url, Course course) {
        this();
        this.setName(name);
        this.setResourceType(resourceType);
        this.setUrl(url);
        this.setCourse(course);
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

    public ResourceType getResourceType() {
        return this.resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Set<License> getLicenses() {
        return this.licenses;
    }

    public void setLicenses(Set<License> licenses) {
        this.licenses = licenses;
    }

    @Override
    public String toString() {
        StringBuilder resource = new StringBuilder();
        resource.append(" Id: " + getId() + System.lineSeparator());
        resource.append(" Name: " + getName() + System.lineSeparator());
        resource.append(" ResourceType: " + getResourceType() + System.lineSeparator());
        resource.append(" Url: " + getUrl() + System.lineSeparator());
        resource.append(" CourseId: " + getCourse().getId() + System.lineSeparator());

        return resource.toString();
    }
}

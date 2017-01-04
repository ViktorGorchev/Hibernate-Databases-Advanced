package app.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "licenses")
public class License implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    public License() {
    }

    public License(String name) {
        this.setName(name);
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

    public Resource getResource() {
        return this.resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}

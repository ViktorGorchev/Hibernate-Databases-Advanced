package app.domain.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "suppliers")
public class Supplier implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Boolean isImporter;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    private Set<Part> parts;

    public Supplier() {
        this.setParts(new HashSet<>());
    }

    public Long getId() {
        return this.id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getImporter() {
        return this.isImporter;
    }

    public void setImporter(Boolean importer) {
        isImporter = importer;
    }

    public Set<Part> getParts() {
        return this.parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}

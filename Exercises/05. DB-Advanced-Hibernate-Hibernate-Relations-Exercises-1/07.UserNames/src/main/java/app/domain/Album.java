package app.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String backgroundColour;

    private Boolean isPublic;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "albums")
    private Set<User> user;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "albums")
    private Set<Picture> pictures;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "albums")
    private Set<Tag> tags;

    public Album() {
        this.setPictures(new HashSet<>());
        this.setTags(new HashSet<>());
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

    public String getBackgroundColour() {
        return this.backgroundColour;
    }

    public void setBackgroundColour(String backgroundColour) {
        this.backgroundColour = backgroundColour;
    }

    public Boolean getPublic() {
        return this.isPublic;
    }

    public void setPublic(Boolean aPublic) {
        this.isPublic = aPublic;
    }

    public Set<User> getUser() {
        return this.user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public Set<Picture> getPictures() {
        return this.pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    public Set<Tag> getTags() {
        return this.tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}
package app.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "tags")
public class Tag {

    private static final String REGEX_TAG = "(^#[^\\s]+$)";
    private static final Integer MAX_TAG_LENGTH  = 20;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tagText;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tags_albums",
            joinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "album_id", referencedColumnName = "id")
    )
    private Set<Album> albums;

    public Tag() {
        this.setAlbums(new HashSet<>());
    }

    public Long getId() {
        return this.id;
    }

    public String getTagText() {
        return this.tagText;
    }

    public void setTagText(String tagText) {
        if (tagText.length() > MAX_TAG_LENGTH || ! this.validatePattern(tagText, REGEX_TAG)) {
            this.tagText = TagTransofrmer.transform(tagText);
        }else {
            this.tagText = tagText;
        }
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

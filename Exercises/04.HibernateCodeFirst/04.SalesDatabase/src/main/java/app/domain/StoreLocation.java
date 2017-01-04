package app.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "store_location")
public class StoreLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String locationName;

    @OneToMany
    @JoinColumn(name = "storeLocation_id")
    private Set<Sale> salesInStore;

    public StoreLocation() {
    }

    public StoreLocation(String locationName) {
        this.setLocationName(locationName);
    }

    public String getLocationName() {
        return this.locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}

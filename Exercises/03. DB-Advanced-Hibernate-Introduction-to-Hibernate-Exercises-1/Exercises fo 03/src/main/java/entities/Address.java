package entities;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;

    @Column(name = "address_text", nullable = false)
    private String addressText;

    @ManyToOne
    @JoinColumn(name = "town_id")
    private Town townId;

    public Address() {
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddressText() {
        return addressText;
    }

    public void setAddressText(String addressText) {
        this.addressText = addressText;
    }

    public Town getTownId() {
        return townId;
    }

    public void setTownId(Town townId) {
        this.townId = townId;
    }
}

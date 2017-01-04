package app.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue(value = "car")
public class Car extends Vehicle implements Serializable {

    private String licencePlate;

    public Car() {
    }

    public String getLicencePlate() {
        return this.licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    @Override
    public String toString() {
        return "Car{" +
                super.toString() +
                " licencePlate='" + licencePlate + '\'' +
                '}';
    }
}

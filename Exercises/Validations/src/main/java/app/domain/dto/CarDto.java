package app.domain.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class CarDto implements Serializable {

    @Expose
    private String name;

    @Expose
    private Integer wheels;

    @Expose
    private String colour;

    @Expose
    @Pattern(message = "Licence plate must contain only capital letters and numbers!", regexp = "[A-Z0-9]+")
    private String licencePlate;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWheels() {
        return this.wheels;
    }

    public void setWheels(Integer wheels) {
        this.wheels = wheels;
    }

    public String getColour() {
        return this.colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getLicencePlate() {
        return this.licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "name='" + name + '\'' +
                ", wheels=" + wheels +
                ", colour='" + colour + '\'' +
                ", licencePlate='" + licencePlate + '\'' +
                '}';
    }
}

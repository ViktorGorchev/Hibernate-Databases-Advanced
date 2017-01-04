package app.domain;


import app.annotation.ValidateColour;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "vehicles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Vehicle implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cant be null!")
    @Pattern(regexp = "[a-z]+", message = "Name must be only small letters!")
    @Size(
            message = "Invalid name size! Size must be between {min} and {max} inclusive!",
            min = 2,
            max = 6
    )
    private String name;

    @Min(value = 1, message = "Wheels must be at least {value}!")
    private Integer wheels;

    @ValidateColour(value = "black")
    private String colour;

    public Vehicle() {
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

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", wheels=" + wheels +
                ", colour='" + colour + '\'';
    }
}

package app.domain.models.camera;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "cameras")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class BasicCamera implements Camera, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String make;

    @NotNull
    private String model;

    private Boolean isFullFrame;

    @NotNull
    @Min(100)
    private Integer minISO;

    private Integer maxISO;

    protected BasicCamera() {
    }

    public BasicCamera(String make, String model, Boolean isFullFrame, Integer minISO, Integer maxISO) {
        this();
        this.setMake(make);
        this.setModel(model);
        this.setFullFrame(isFullFrame);
        this.setMinISO(minISO);
        this.setMaxISO(maxISO);
    }

    @Override
    public Long getId() {
        return this.id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getMake() {
        return this.make;
    }

    @Override
    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public Boolean getFullFrame() {
        return this.isFullFrame;
    }

    @Override
    public void setFullFrame(Boolean fullFrame) {
        isFullFrame = fullFrame;
    }

    @Override
    public Integer getMinISO() {
        return this.minISO;
    }

    @Override
    public void setMinISO(Integer minISO) {
        this.minISO = minISO;
    }

    @Override
    public Integer getMaxISO() {
        return this.maxISO;
    }

    @Override
    public void setMaxISO(Integer maxISO) {
        this.maxISO = maxISO;
    }
}

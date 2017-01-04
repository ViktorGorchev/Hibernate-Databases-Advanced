package app.domain.models.camera;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("DSLR")
public class DSLRCamera extends BasicCamera implements Serializable {

    private Integer maxShutterSpeed;

    public DSLRCamera() {
    }

    public DSLRCamera(
            String make,
            String model,
            Boolean isFullFrame,
            Integer minISO,
            Integer maxISO,
            Integer maxShutterSpeed) {
        super(make, model, isFullFrame, minISO, maxISO);
        this.setMaxShutterSpeed(maxShutterSpeed);
    }

    public Integer getMaxShutterSpeed() {
        return this.maxShutterSpeed;
    }

    public void setMaxShutterSpeed(Integer maxShutterSpeed) {
        this.maxShutterSpeed = maxShutterSpeed;
    }
}

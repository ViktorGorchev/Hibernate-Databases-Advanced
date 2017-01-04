package app.domain.models.camera;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("Mirrorless")
public class MirrorlessCamera extends BasicCamera implements Serializable {

    @Column(columnDefinition = "TEXT")
    private String maxVideoResolution;

    private Integer maxFrameRate;

    public MirrorlessCamera() {
    }

    public MirrorlessCamera(
            String make,
            String model,
            Boolean isFullFrame,
            Integer minISO,
            Integer maxISO,
            String maxVideoResolution,
            Integer maxFrameRate) {
        super(make, model, isFullFrame, minISO, maxISO);
        this.setMaxVideoResolution(maxVideoResolution);
        this.setMaxFrameRate(maxFrameRate);
    }

    public String getMaxVideoResolution() {
        return this.maxVideoResolution;
    }

    public void setMaxVideoResolution(String maxVideoResolution) {
        this.maxVideoResolution = maxVideoResolution;
    }

    public Integer getMaxFrameRate() {
        return this.maxFrameRate;
    }

    public void setMaxFrameRate(Integer maxFrameRate) {
        this.maxFrameRate = maxFrameRate;
    }
}

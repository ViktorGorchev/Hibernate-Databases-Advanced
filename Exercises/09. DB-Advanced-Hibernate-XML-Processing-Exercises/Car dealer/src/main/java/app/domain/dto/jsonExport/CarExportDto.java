package app.domain.dto.jsonExport;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.math.BigInteger;

public class CarExportDto implements Serializable {

    @Expose
    private Long id;

    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private BigInteger travelledDistance;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigInteger getTravelledDistance() {
        return this.travelledDistance;
    }

    public void setTravelledDistance(BigInteger travelledDistance) {
        this.travelledDistance = travelledDistance;
    }
}

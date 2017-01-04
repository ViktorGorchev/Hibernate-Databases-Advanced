package app.domain.dto.jsonExport;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;

public class CarPartExportDto implements Serializable {

    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private BigInteger travelledDistance;

    @Expose
    private Set<PartExportDto> parts;

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

    public Set<PartExportDto> getParts() {
        return this.parts;
    }

    public void setParts(Set<PartExportDto> parts) {
        this.parts = parts;
    }
}
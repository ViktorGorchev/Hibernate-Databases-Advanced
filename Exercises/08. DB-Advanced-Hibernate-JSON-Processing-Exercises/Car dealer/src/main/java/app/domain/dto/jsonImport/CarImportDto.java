package app.domain.dto.jsonImport;


import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.math.BigInteger;

public class CarImportDto implements Serializable{

    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private BigInteger travelledDistance;

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

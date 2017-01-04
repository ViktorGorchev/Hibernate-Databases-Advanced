package app.domain.dto.xmlExport.carsWithListOfParts;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigInteger;

@XmlRootElement(name = "car")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class CarPartExportXmlDto implements Serializable {

    @XmlAttribute
    private String make;

    @XmlAttribute
    private String model;

    @XmlAttribute(name = "travelled-distance")
    private BigInteger travelledDistance;

    @XmlElement(name = "parts")
    private PartsXmlExportDto parts;

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

    public PartsXmlExportDto getParts() {
        return this.parts;
    }

    public void setParts(PartsXmlExportDto parts) {
        this.parts = parts;
    }
}
package app.domain.dto.xmlExport.testColectionOfElemnts;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;

@XmlRootElement(name = "car")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class CarPartXmlExportDto implements Serializable {

    @XmlElement
    private String make;

    @XmlElement
    private String model;

    @XmlElement(name = "travelled-distance")
    private BigInteger travelledDistance;

    @XmlElementWrapper(name = "parts")
    @XmlElement(name = "part")
    private Set<PartXmlExportDto> parts;

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

    public Set<PartXmlExportDto> getParts() {
        return this.parts;
    }

    public void setParts(Set<PartXmlExportDto> parts) {
        this.parts = parts;
    }
}
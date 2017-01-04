package app.domain.dto.xmlImport.workshop;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "workshop")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopXmlDto implements Serializable {

    @NotNull
    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "start-date")
    private Date startDate;

    @XmlAttribute(name = "end-date")
    private Date endDate;

    @NotNull
    @XmlAttribute
    private String location;

    @NotNull
    @XmlAttribute
    private BigDecimal price;

    @NotNull
    @XmlElement(name = "trainer")
    private String trainerFullName;

    @XmlElementWrapper(name = "participants")
    @XmlElement(name = "participant")
    List<PhotographerXmlDto> participants;

    public WorkshopXmlDto() {
        this.setParticipants(new ArrayList<>());
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTrainerFullName() {
        return this.trainerFullName;
    }

    public void setTrainerFullName(String trainerFullName) {
        this.trainerFullName = trainerFullName;
    }

    public List<PhotographerXmlDto> getParticipants() {
        return this.participants;
    }

    public void setParticipants(List<PhotographerXmlDto> participants) {
        this.participants = participants;
    }
}

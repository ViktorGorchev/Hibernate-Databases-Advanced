package app.domain.dto.xmlExport;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;

@XmlRootElement(name = "customer")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class CustomerExportXmlDto implements Serializable{

    @XmlElement
    private Long id;

    @XmlElement
    private String name;

    @XmlElement(name = "birth-date")
    private Date birthDate;

    @XmlElement(name = "is-young-driver")
    private Boolean isYoungDriver;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getYoungDriver() {
        return this.isYoungDriver;
    }

    public void setYoungDriver(Boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}

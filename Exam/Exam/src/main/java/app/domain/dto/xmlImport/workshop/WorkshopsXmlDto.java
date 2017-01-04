package app.domain.dto.xmlImport.workshop;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "workshops")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopsXmlDto implements Serializable {

    @XmlElement(name = "workshop")
    List<WorkshopXmlDto> workshopXmlDtos;

    public WorkshopsXmlDto() {
        this.setWorkshopXmlDtos(new ArrayList<>());
    }

    public List<WorkshopXmlDto> getWorkshopXmlDtos() {
        return this.workshopXmlDtos;
    }

    public void setWorkshopXmlDtos(List<WorkshopXmlDto> workshopXmlDtos) {
        this.workshopXmlDtos = workshopXmlDtos;
    }
}

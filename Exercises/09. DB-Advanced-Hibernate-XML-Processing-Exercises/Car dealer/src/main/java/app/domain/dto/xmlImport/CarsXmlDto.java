package app.domain.dto.xmlImport;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class CarsXmlDto implements Serializable {

    @XmlElement(name = "car")
    List<CarImportXmlDto> carImportXmlDtos;

    public CarsXmlDto() {
        this.setCarImportXmlDtos(new ArrayList<>());
    }

    public List<CarImportXmlDto> getCarImportXmlDtos() {
        return this.carImportXmlDtos;
    }

    public void setCarImportXmlDtos(List<CarImportXmlDto> carImportXmlDtos) {
        this.carImportXmlDtos = carImportXmlDtos;
    }
}

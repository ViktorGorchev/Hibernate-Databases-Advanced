package app.domain.dto.xmlExport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class CarsXmlExportDto implements Serializable {

    @XmlElement(name = "car")
    List<CarExportXmlDto> carExportXmlDtos;

    public CarsXmlExportDto() {
        this.setCarExportXmlDtos(new ArrayList<>());
    }

    public List<CarExportXmlDto> getCarExportXmlDtos() {
        return this.carExportXmlDtos;
    }

    public void setCarExportXmlDtos(List<CarExportXmlDto> carExportXmlDtos) {
        this.carExportXmlDtos = carExportXmlDtos;
    }
}

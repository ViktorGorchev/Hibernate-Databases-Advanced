package app.domain.dto.xmlExport.carsWithListOfParts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class CarPartsXmlExportDto implements Serializable{

    @XmlElement(name = "car")
    List<CarPartExportXmlDto> carPartExportXmlDtos;

    public CarPartsXmlExportDto() {
        this.setCarPartExportXmlDtos(new ArrayList<>());
    }

    public List<CarPartExportXmlDto> getCarPartExportXmlDtos() {
        return this.carPartExportXmlDtos;
    }

    public void setCarPartExportXmlDtos(List<CarPartExportXmlDto> carPartExportXmlDtos) {
        this.carPartExportXmlDtos = carPartExportXmlDtos;
    }
}

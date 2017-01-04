package app.domain.dto.xmlExport.testColectionOfElemnts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class CarsTestXmlExportDto implements Serializable {

    private List<CarPartXmlExportDto> carPartXmlExportDtos;

    public CarsTestXmlExportDto() {
        this.setCarPartXmlExportDtos(new ArrayList<>());
    }

    public List<CarPartXmlExportDto> getCarPartXmlExportDtos() {
        return this.carPartXmlExportDtos;
    }

    public void setCarPartXmlExportDtos(List<CarPartXmlExportDto> carPartXmlExportDtos) {
        this.carPartXmlExportDtos = carPartXmlExportDtos;
    }
}

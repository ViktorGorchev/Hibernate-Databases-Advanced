package app.domain.dto.xmlExport.carsWithListOfParts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class PartsXmlExportDto implements Serializable {

    @XmlElement(name = "part")
    private List<PartExportXmlDto> partExportXmlDtos;

    public PartsXmlExportDto() {
        this.setPartExportXmlDtos(new ArrayList<>());
    }

    public List<PartExportXmlDto> getPartExportXmlDtos() {
        return this.partExportXmlDtos;
    }

    public void setPartExportXmlDtos(List<PartExportXmlDto> partExportXmlDtos) {
        this.partExportXmlDtos = partExportXmlDtos;
    }
}

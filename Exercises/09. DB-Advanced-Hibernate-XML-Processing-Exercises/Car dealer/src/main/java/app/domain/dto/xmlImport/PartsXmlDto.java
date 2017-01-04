package app.domain.dto.xmlImport;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class PartsXmlDto implements Serializable{

    @XmlElement(name = "part")
    List<PartImportXmlDto> partImportXmlDtos;

    public PartsXmlDto() {
        this.setPartImportXmlDtos(new ArrayList<>());
    }

    public List<PartImportXmlDto> getPartImportXmlDtos() {
        return this.partImportXmlDtos;
    }

    public void setPartImportXmlDtos(List<PartImportXmlDto> partImportXmlDtos) {
        this.partImportXmlDtos = partImportXmlDtos;
    }
}

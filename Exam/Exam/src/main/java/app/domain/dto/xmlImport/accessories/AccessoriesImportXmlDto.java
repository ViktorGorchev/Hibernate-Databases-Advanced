package app.domain.dto.xmlImport.accessories;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "accessories")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class AccessoriesImportXmlDto implements Serializable {

    @XmlElement(name = "accessory")
    List<AccessoryImportXmlDto> accessoryImportXmlDtos;

    public AccessoriesImportXmlDto() {
        this.setAccessoryImportXmlDtos(new ArrayList<>());
    }

    public List<AccessoryImportXmlDto> getAccessoryImportXmlDtos() {
        return this.accessoryImportXmlDtos;
    }

    public void setAccessoryImportXmlDtos(List<AccessoryImportXmlDto> accessoryImportXmlDtos) {
        this.accessoryImportXmlDtos = accessoryImportXmlDtos;
    }
}

package app.domain.dto.xmlImport.accessories;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "accessory")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class AccessoryImportXmlDto implements Serializable {

    @XmlAttribute
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

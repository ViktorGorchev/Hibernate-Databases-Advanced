package app.domain.dto.xmlExport.testColectionOfElemnts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;

@XmlRootElement(name = "part")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class PartXmlExportDto implements Serializable {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private BigDecimal price;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

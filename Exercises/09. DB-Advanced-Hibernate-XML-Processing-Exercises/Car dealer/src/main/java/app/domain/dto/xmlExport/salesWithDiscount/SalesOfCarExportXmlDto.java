package app.domain.dto.xmlExport.salesWithDiscount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class SalesOfCarExportXmlDto implements Serializable {

    @XmlElement(name = "sale")
    List<SaleCarExportXmlDto> saleCarExportXmlDtos;

    public SalesOfCarExportXmlDto() {
        this.setSaleCarExportXmlDtos(new ArrayList<>());
    }

    public List<SaleCarExportXmlDto> getSaleCarExportXmlDtos() {
        return this.saleCarExportXmlDtos;
    }

    public void setSaleCarExportXmlDtos(List<SaleCarExportXmlDto> saleCarExportXmlDtos) {
        this.saleCarExportXmlDtos = saleCarExportXmlDtos;
    }
}

package app.domain.dto.xmlExport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class SuppliersXmlExportDto implements Serializable{

    @XmlElement(name = "supplier")
    List<SupplierExportXmlDto> supplierExportXmlDtos;

    public SuppliersXmlExportDto() {
        this.setSupplierExportXmlDtos(new ArrayList<>());
    }

    public List<SupplierExportXmlDto> getSupplierExportXmlDtos() {
        return this.supplierExportXmlDtos;
    }

    public void setSupplierExportXmlDtos(List<SupplierExportXmlDto> supplierExportXmlDtos) {
        this.supplierExportXmlDtos = supplierExportXmlDtos;
    }
}

package app.domain.dto.xmlImport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class SuppliersXmLDto implements Serializable{

    @XmlElement(name = "supplier")
    List<SupplierImportXmlDto> supplierImportXmlDtos;

    public SuppliersXmLDto() {
        this.setSupplierImportXmlDtos(new ArrayList<>());
    }

    public List<SupplierImportXmlDto> getSupplierImportXmlDtos() {
        return this.supplierImportXmlDtos;
    }

    public void setSupplierImportXmlDtos(List<SupplierImportXmlDto> supplierImportXmlDtos) {
        this.supplierImportXmlDtos = supplierImportXmlDtos;
    }
}

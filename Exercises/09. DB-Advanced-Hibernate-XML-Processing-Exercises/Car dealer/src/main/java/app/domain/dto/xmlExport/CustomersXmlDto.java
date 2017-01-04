package app.domain.dto.xmlExport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class CustomersXmlDto implements Serializable {

    @XmlElement(name = "customer")
    List<CustomerExportXmlDto> customerExportXmlDtos;

    public CustomersXmlDto() {
        this.setCustomerExportXmlDtos(new ArrayList<>());
    }

    public List<CustomerExportXmlDto> getCustomerExportXmlDtos() {
        return this.customerExportXmlDtos;
    }

    public void setCustomerExportXmlDtos(List<CustomerExportXmlDto> customerExportXmlDtos) {
        this.customerExportXmlDtos = customerExportXmlDtos;
    }
}

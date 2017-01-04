package app.domain.dto.xmlExport.customersStatus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class CustomersXmlStatusExportDto implements Serializable {

    @XmlElement(name = "customer")
    List<CustomerStatusExportXmlDto> customerStatusExportXmlDtos;

    public CustomersXmlStatusExportDto() {
        this.setCustomerStatusExportXmlDtos(new ArrayList<>());
    }

    public List<CustomerStatusExportXmlDto> getCustomerStatusExportXmlDtos() {
        return this.customerStatusExportXmlDtos;
    }

    public void setCustomerStatusExportXmlDtos(List<CustomerStatusExportXmlDto> customerStatusExportXmlDtos) {
        this.customerStatusExportXmlDtos = customerStatusExportXmlDtos;
    }
}

package app.domain.dto.xmlImport;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class CustomersXmlDtos implements Serializable {

    @XmlElement(name = "customer")
    List<CustomerImportXmlDto> customerImportXmlDtos;

    public CustomersXmlDtos() {
        this.setCustomerImportXmlDtos(new ArrayList<>());
    }

    public List<CustomerImportXmlDto> getCustomerImportXmlDtos() {
        return this.customerImportXmlDtos;
    }

    public void setCustomerImportXmlDtos(List<CustomerImportXmlDto> customerImportXmlDtos) {
        this.customerImportXmlDtos = customerImportXmlDtos;
    }
}

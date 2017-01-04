package app.domain.dto.xmlExport.customersStatus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;

@XmlRootElement(name = "customer")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class CustomerStatusExportXmlDto implements Serializable {

    @XmlAttribute(name = "full-name")
    private String name;

    @XmlAttribute(name = "bought-cars")
    private Integer boughtCarsCount;

    @XmlAttribute(name = "spent-money")
    private BigDecimal totalMoneySpend;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBoughtCarsCount() {
        return this.boughtCarsCount;
    }

    public void setBoughtCarsCount(Integer boughtCarsCount) {
        this.boughtCarsCount = boughtCarsCount;
    }

    public BigDecimal getTotalMoneySpend() {
        return this.totalMoneySpend;
    }

    public void setTotalMoneySpend(BigDecimal totalMoneySpend) {
        this.totalMoneySpend = totalMoneySpend;
    }
}

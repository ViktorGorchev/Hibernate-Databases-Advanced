package app.domain.dto.xmlExport.salesWithDiscount;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;

@XmlRootElement(name = "sale")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class SaleCarExportXmlDto implements Serializable{

    @XmlElement
    private CarSaleExportXmlDto car;

    @XmlElement(name = "customer-name")
    private String customerName;

    @XmlElement
    private Integer discount;

    @XmlElement(name = "price")
    private BigDecimal carCarPrice;

    @XmlElement(name = "price-with-discount")
    private BigDecimal priceWithDiscount;

    public CarSaleExportXmlDto getCar() {
        return this.car;
    }

    public void setCar(CarSaleExportXmlDto car) {
        this.car = car;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getDiscount() {
        return this.discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public BigDecimal getCarCarPrice() {
        return this.carCarPrice;
    }

    public void setCarCarPrice(BigDecimal carCarPrice) {
        this.carCarPrice = carCarPrice;
    }

    public BigDecimal getPriceWithDiscount() {
        return this.priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}

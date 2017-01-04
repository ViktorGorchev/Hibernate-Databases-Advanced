package app.domain.dto.jsonExport;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

public class SaleCarExportDto implements Serializable{

    @Expose
    private CarSaleExportDto car;

    @Expose
    private String customerName;

    @Expose
    private Integer discount;

    @SerializedName(value = "price")
    @Expose
    private BigDecimal carCarPrice;

    @Expose
    private BigDecimal priceWithDiscount;

    public CarSaleExportDto getCar() {
        return this.car;
    }

    public void setCar(CarSaleExportDto car) {
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

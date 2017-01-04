package app.domain.dto;

import app.domain.dto.jsonImport.CarImportDto;
import app.domain.dto.jsonImport.CustomerImportDto;
import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class SaleDto implements Serializable {

    @Expose
    private CarImportDto car;

    @Expose
    private CustomerImportDto customer;

    @Expose
    private Integer discount;

    public CarImportDto getCar() {
        return this.car;
    }

    public void setCar(CarImportDto car) {
        this.car = car;
    }

    public CustomerImportDto getCustomer() {
        return this.customer;
    }

    public void setCustomer(CustomerImportDto customer) {
        this.customer = customer;
    }

    public Integer getDiscount() {
        return this.discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}

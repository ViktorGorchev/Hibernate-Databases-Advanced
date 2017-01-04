package app.domain.dto.jsonExport;

import app.domain.dto.SaleDto;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class CustomerExportDto implements Serializable{

    @SerializedName(value = "Id")
    @Expose
    private Long id;

    @SerializedName(value = "Name")
    @Expose
    private String name;

    @SerializedName(value = "BirthDate")
    @Expose
    private Date birthDate;

    @SerializedName(value = "IsYoungDriver")
    @Expose
    private Boolean isYoungDriver;

    @SerializedName(value = "Sales")
    @Expose
    private Set<SaleDto> sales;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getYoungDriver() {
        return this.isYoungDriver;
    }

    public void setYoungDriver(Boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public Set<SaleDto> getSales() {
        return this.sales;
    }

    public void setSales(Set<SaleDto> sales) {
        this.sales = sales;
    }
}

package app.domain.dto.jsonExport;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

public class CustomerStatusExportDto implements Serializable {

    @SerializedName(value = "fullName")
    @Expose
    private String name;

    @SerializedName(value = "boughtCars")
    @Expose
    private Integer boughtCarsCount;

    @SerializedName(value = "spentMoney")
    @Expose
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

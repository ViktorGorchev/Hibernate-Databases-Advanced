package app.domain.dto.jsonExport;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class CategoryStatusDto {

    @SerializedName(value = "category")
    @Expose
    private String name;

    @Expose
    private Integer productsCount;

    @Expose
    private BigDecimal averagePrice;

    @Expose
    private BigDecimal totalRevenue;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProductsCount() {
        return this.productsCount;
    }

    public void setProductsCount(Integer productsCount) {
        this.productsCount = productsCount;
    }

    public BigDecimal getAveragePrice() {
        return this.averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getTotalRevenue() {
        return this.totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}

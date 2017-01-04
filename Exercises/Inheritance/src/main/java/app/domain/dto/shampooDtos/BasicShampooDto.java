package app.domain.dto.shampooDtos;

import java.io.Serializable;
import java.math.BigDecimal;

public class BasicShampooDto implements Serializable {


    private String brand;

    private BigDecimal price;

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

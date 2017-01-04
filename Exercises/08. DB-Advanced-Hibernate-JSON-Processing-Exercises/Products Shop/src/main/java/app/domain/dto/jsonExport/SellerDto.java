package app.domain.dto.jsonExport;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Set;

public class SellerDto implements Serializable{

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @SerializedName(value = "soldProducts")
    @Expose
    private Set<SoldProductDto> productsSold;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<SoldProductDto> getProductsSold() {
        return this.productsSold;
    }

    public void setProductsSold(Set<SoldProductDto> productsSold) {
        this.productsSold = productsSold;
    }
}

package app.domain.dto.jsonExport;

import com.google.gson.annotations.Expose;

public class UserDto {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private Integer age;

    @Expose
    private ProductStatus soldProducts;

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

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public ProductStatus getSoldProducts() {
        return this.soldProducts;
    }

    public void setSoldProducts(ProductStatus soldProducts) {
        this.soldProducts = soldProducts;
    }
}

package app.domain.dto.jsonImport;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;


public class PhotographerImportDto implements Serializable {

    @Expose
    @NotNull
    private String firstName;

    @Expose
    @NotNull
    private String lastName;

    @Expose
    @Pattern(regexp = "^[+]*\\d{1,3}\\/\\d{8,10}$")
    private String phone;

    @Expose
    private List<Long> lenses;

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

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Long> getLenses() {
        return this.lenses;
    }

    public void setLenses(List<Long> lenses) {
        this.lenses = lenses;
    }
}

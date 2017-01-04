package app.domain.dto.jsonImport;

import com.google.gson.annotations.Expose;

import java.io.Serializable;


public class CustomerImportDto implements Serializable {

    @Expose
    private String name;

    @Expose
    private String birthDate;

    @Expose
    private Boolean isYoungDriver;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getYoungDriver() {
        return this.isYoungDriver;
    }

    public void setYoungDriver(Boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}

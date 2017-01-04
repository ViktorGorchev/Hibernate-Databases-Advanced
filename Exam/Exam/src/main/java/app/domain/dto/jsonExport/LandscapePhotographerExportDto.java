package app.domain.dto.jsonExport;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigInteger;

public class LandscapePhotographerExportDto implements Serializable {

    @SerializedName("FirstName")
    @Expose
    private String firstName;

    @SerializedName("LastName")
    @Expose
    private String lastName;

    @SerializedName("CameraMake")
    @Expose
    private String cameraMake;

    @SerializedName("LensesCount")
    @Expose
    private BigInteger lensesCount;

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

    public String getCameraMake() {
        return this.cameraMake;
    }

    public void setCameraMake(String cameraMake) {
        this.cameraMake = cameraMake;
    }

    public BigInteger getLensesCount() {
        return this.lensesCount;
    }

    public void setLensesCount(BigInteger lensesCount) {
        this.lensesCount = lensesCount;
    }
}

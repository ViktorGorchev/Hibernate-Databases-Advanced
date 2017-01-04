package app.domain.dto.jsonExport;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class SupplierExportDto implements Serializable {

    @Expose
    private Long id;

    @Expose
    private String name;

    @Expose
    private Integer partsCount;

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

    public Integer getPartsCount() {
        return this.partsCount;
    }

    public void setPartsCount(Integer partsCount) {
        this.partsCount = partsCount;
    }
}

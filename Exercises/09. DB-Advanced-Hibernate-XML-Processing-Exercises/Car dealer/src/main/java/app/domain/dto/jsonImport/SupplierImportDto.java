package app.domain.dto.jsonImport;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class SupplierImportDto implements Serializable {

    @Expose
    private String name;

    @Expose
    private Boolean isImporter;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getImporter() {
        return this.isImporter;
    }

    public void setImporter(Boolean importer) {
        isImporter = importer;
    }
}

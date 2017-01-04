package app.services.supplier;

import app.domain.dto.jsonExport.SupplierExportDto;
import app.domain.dto.jsonImport.SupplierImportDto;

import java.util.List;

public interface SupplierService {

    void create(SupplierImportDto supplierImportDto);

    List<SupplierExportDto> findNotImporters();
}
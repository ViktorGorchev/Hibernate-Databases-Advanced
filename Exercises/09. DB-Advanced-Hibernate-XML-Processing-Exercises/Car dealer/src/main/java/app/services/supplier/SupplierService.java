package app.services.supplier;

import app.domain.dto.jsonExport.SupplierExportDto;
import app.domain.dto.jsonImport.SupplierImportDto;
import app.domain.dto.xmlExport.SuppliersXmlExportDto;
import app.domain.dto.xmlImport.SupplierImportXmlDto;

import java.util.List;

public interface SupplierService {

    void create(SupplierImportDto supplierImportDto);

    void create(SupplierImportXmlDto supplierImportXmlDto);

    List<SupplierExportDto> findNotImporters();

    SuppliersXmlExportDto findXmlNotImporters();
}
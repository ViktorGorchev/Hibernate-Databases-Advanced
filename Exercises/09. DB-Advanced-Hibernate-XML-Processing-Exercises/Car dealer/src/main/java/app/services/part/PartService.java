package app.services.part;

import app.domain.dto.jsonImport.PartImportDto;
import app.domain.dto.xmlImport.PartImportXmlDto;

public interface PartService {

    void create(PartImportDto partImportDto);

    void create(PartImportXmlDto partImportXmlDto);
}
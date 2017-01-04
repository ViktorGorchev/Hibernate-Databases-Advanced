package app.services.part;

import app.domain.dto.jsonImport.PartImportDto;

public interface PartService {

    void create(PartImportDto partImportDto);
}
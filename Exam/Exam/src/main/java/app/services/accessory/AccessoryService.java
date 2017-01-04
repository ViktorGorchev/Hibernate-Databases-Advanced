package app.services.accessory;

import app.domain.dto.xmlImport.accessories.AccessoryImportXmlDto;

public interface AccessoryService {

    void create(AccessoryImportXmlDto accessoryImportXmlDto);
}
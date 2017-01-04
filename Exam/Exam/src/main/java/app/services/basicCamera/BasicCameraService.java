package app.services.basicCamera;

import app.domain.dto.jsonImport.BasicCameraImportDto;

public interface BasicCameraService {

    void create(BasicCameraImportDto basicCameraImportDto);
}
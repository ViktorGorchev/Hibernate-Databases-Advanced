package app.services.photographer;

import app.domain.dto.jsonExport.LandscapePhotographerExportDto;
import app.domain.dto.jsonExport.PhotographerExportDto;
import app.domain.dto.jsonImport.PhotographerImportDto;

import java.util.List;

public interface PhotographerService {

    String create(PhotographerImportDto photographerImportDto);

    List<PhotographerExportDto> findAllPhotographersOrdered();

    List<LandscapePhotographerExportDto> findAllLandscapePhotographers();
}
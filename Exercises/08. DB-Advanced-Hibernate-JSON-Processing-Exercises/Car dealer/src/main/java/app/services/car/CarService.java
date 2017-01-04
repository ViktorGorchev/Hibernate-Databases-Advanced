package app.services.car;

import app.domain.dto.jsonExport.CarExportDto;
import app.domain.dto.jsonExport.CarPartExportDto;
import app.domain.dto.jsonImport.CarImportDto;

import java.util.List;

public interface CarService {

    void create(CarImportDto carImportDto);

    List<CarExportDto> findCarsByMake(String make);

    List<CarPartExportDto> findAllCars();
}
package app.services.car;

import app.domain.dto.jsonExport.CarExportDto;
import app.domain.dto.jsonExport.CarPartExportDto;
import app.domain.dto.jsonImport.CarImportDto;
import app.domain.dto.xmlExport.CarsXmlExportDto;
import app.domain.dto.xmlExport.carsWithListOfParts.CarPartsXmlExportDto;
import app.domain.dto.xmlExport.testColectionOfElemnts.CarsTestXmlExportDto;
import app.domain.dto.xmlImport.CarImportXmlDto;

import java.util.List;

public interface CarService {

    void create(CarImportDto carImportDto);

    void create(CarImportXmlDto carImportXmlDto);

    List<CarExportDto> findCarsByMake(String make);

    CarsXmlExportDto findXmlCarsByMake(String make);

    List<CarPartExportDto> findAllCars();

    CarPartsXmlExportDto findXmlAllCars();

    CarsTestXmlExportDto findXmlAllCarsTestArray();
}
package app.services.car;

import app.constants.AppConstants;
import app.domain.dto.jsonExport.CarExportDto;
import app.domain.dto.jsonExport.CarPartExportDto;
import app.domain.dto.jsonImport.CarImportDto;
import app.domain.dto.xmlExport.CarExportXmlDto;
import app.domain.dto.xmlExport.CarsXmlExportDto;
import app.domain.dto.xmlExport.carsWithListOfParts.CarPartExportXmlDto;
import app.domain.dto.xmlExport.carsWithListOfParts.CarPartsXmlExportDto;
import app.domain.dto.xmlExport.testColectionOfElemnts.CarPartXmlExportDto;
import app.domain.dto.xmlExport.testColectionOfElemnts.CarsTestXmlExportDto;
import app.domain.dto.xmlImport.CarImportXmlDto;
import app.domain.models.Car;
import app.domain.models.Part;
import app.parser.modelParser.ModelParser;
import app.repositories.CarRepository;
import app.repositories.PartRepository;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
	private CarRepository carRepository;

    @Autowired
    private PartRepository partRepository;

    @Autowired
	private ModelParser modelParser;

	@Override
	public void create(CarImportDto carImportDto) {
		Car car = this.modelParser.convert(carImportDto, Car.class);
        car.setParts(this.randomParts());
		this.carRepository.saveAndFlush(car);
	}

    @Override
    public void create(CarImportXmlDto carImportXmlDto) {
        Car car = this.modelParser.convert(carImportXmlDto, Car.class);
        car.setParts(this.randomParts());
        this.carRepository.saveAndFlush(car);
    }

    @Override
    public List<CarExportDto> findCarsByMake(String make) {
        List<Car> cars = this.carRepository.findByMakeOrderByModelAscTravelledDistanceDesc(make);
        List<CarExportDto> carDtos = this.modelParser.convert(cars, CarExportDto.class);

        return carDtos;
    }

    @Override
    public CarsXmlExportDto findXmlCarsByMake(String make) {
        List<Car> cars = this.carRepository.findByMakeOrderByModelAscTravelledDistanceDesc(make);
        List<CarExportXmlDto> carDtos = this.modelParser.convert(cars, CarExportXmlDto.class);
        CarsXmlExportDto carsXmlExportDto = new CarsXmlExportDto();
        carsXmlExportDto.setCarExportXmlDtos(carDtos);

        return carsXmlExportDto;
    }

    @Override
    public List<CarPartExportDto> findAllCars() {
        List<Car> cars = this.carRepository.findAll();
        List<CarPartExportDto> carPartExportDtos = this.modelParser.convert(cars, CarPartExportDto.class);

        return carPartExportDtos;
    }

    @Override
    public CarPartsXmlExportDto findXmlAllCars() {
        List<Car> cars = this.carRepository.findAll();

        PropertyMap<Car, CarPartExportXmlDto> propertyMap = new PropertyMap<Car, CarPartExportXmlDto>() {
            @Override
            protected void configure() {
                map(source.getParts(), destination.getParts().getPartExportXmlDtos());
            }
        };
        List<CarPartExportXmlDto> carPartExportXmlDtos =
                this.modelParser.convert(cars, CarPartExportXmlDto.class, propertyMap);

        CarPartsXmlExportDto carPartsXmlExportDto = new CarPartsXmlExportDto();
        carPartsXmlExportDto.setCarPartExportXmlDtos(carPartExportXmlDtos);

        return carPartsXmlExportDto;
    }

    @Override
    public CarsTestXmlExportDto findXmlAllCarsTestArray() {
        List<Car> cars = this.carRepository.findAll();

        List<CarPartXmlExportDto> carPartXmlExportDtos = this.modelParser.convert(cars, CarPartXmlExportDto.class);

        CarsTestXmlExportDto carsTestXmlExportDto = new CarsTestXmlExportDto();
        carsTestXmlExportDto.setCarPartXmlExportDtos(carPartXmlExportDtos);

        return carsTestXmlExportDto;
    }

    private Set<Part> randomParts() {
        Set<Part> parts = new HashSet<>();
        Integer randomPartsAmount =
                ThreadLocalRandom.current().nextInt(AppConstants.MIN_PARTS_IN_CAR, AppConstants.MAX_PARTS_IN_CAR + 1);

        while (parts.size() < randomPartsAmount){
            Long randomPartId = ThreadLocalRandom.current().nextLong(1, this.partRepository.count() + 1);
            Part part = this.partRepository.findOne(randomPartId);
            parts.add(part);
        }

        return parts;
    }
}
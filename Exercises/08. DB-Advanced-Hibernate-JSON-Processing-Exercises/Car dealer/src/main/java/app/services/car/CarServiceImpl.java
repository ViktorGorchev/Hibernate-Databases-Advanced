package app.services.car;

import app.constants.AppConstants;
import app.domain.dto.jsonExport.CarExportDto;
import app.domain.dto.jsonExport.CarPartExportDto;
import app.domain.dto.jsonImport.CarImportDto;
import app.domain.models.Car;
import app.domain.models.Part;
import app.parser.ModelParser;
import app.repositories.CarRepository;
import app.repositories.PartRepository;
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
    public List<CarExportDto> findCarsByMake(String make) {
        List<Car> cars = this.carRepository.findByMakeOrderByModelAscTravelledDistanceDesc(make);
        List<CarExportDto> carDtos = this.modelParser.convert(cars, CarExportDto.class);

        return carDtos;
    }

    @Override
    public List<CarPartExportDto> findAllCars() {
        List<Car> cars = this.carRepository.findAll();
        List<CarPartExportDto> carPartExportDtos = this.modelParser.convert(cars, CarPartExportDto.class);

        return carPartExportDtos;
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
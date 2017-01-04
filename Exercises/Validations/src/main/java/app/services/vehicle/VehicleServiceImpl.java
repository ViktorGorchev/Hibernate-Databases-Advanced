package app.services.vehicle;

import app.domain.Car;
import app.domain.Vehicle;
import app.domain.dto.CarDto;
import app.parser.modelParser.ModelParser;
import app.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

    @Autowired
    private ModelParser modelParser;


    @Override
    public void create(CarDto carDto) {
        Car car = this.modelParser.convert(carDto, Car.class);
        this.vehicleRepository.saveAndFlush(car);
    }

    @Override
    public CarDto findById(Long id) {
        Vehicle car = this.vehicleRepository.findOne(id);
        CarDto carDto = this.modelParser.convert(car, CarDto.class);

        return carDto;
    }
}
package app.terminal;


import app.domain.dto.CarDto;
import app.services.vehicle.VehicleService;
import app.validator.DtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ValidationException;

@Component
public class Terminal implements CommandLineRunner{

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private DtoValidator dtoValidator;

    @Override
    public void run(String... strings) throws Exception {

        //validate entity
        try{
            this.vehicleService.create(this.factoryForCarDto());
        }catch (ValidationException ve){
            //ve.printStackTrace();
            System.out.println(ve.getMessage());
        }

        //validate DTO
        CarDto carDto = this.factoryForCarDto();
        if (! this.dtoValidator.isValid(carDto)){
            for (ConstraintViolation<CarDto> carDtoConstraintViolation : this.dtoValidator.getErrors(carDto)) {
                System.out.println(carDtoConstraintViolation.getMessage());
            }

            throw new ValidationException();
        }

        this.vehicleService.create(carDto);

        //find car in DB
        CarDto carDtoFromDB = this.vehicleService.findById(1L);
        System.out.println(carDtoFromDB.toString());

    }

    private CarDto factoryForCarDto(){
        CarDto carDto = new CarDto();
        carDto.setName("toYota");
        carDto.setWheels(0);
        carDto.setColour("black");
        carDto.setLicencePlate("AK4566FF");

        return carDto;
    }
}

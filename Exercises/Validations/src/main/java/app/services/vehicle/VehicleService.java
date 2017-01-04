package app.services.vehicle;

import app.domain.dto.CarDto;

public interface VehicleService {

    void create(CarDto carDto);

    CarDto findById(Long id);
}
package app.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import app.domain.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
}
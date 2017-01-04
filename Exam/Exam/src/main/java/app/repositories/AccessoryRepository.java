package app.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import app.domain.models.Accessory;

@Repository
public interface AccessoryRepository extends JpaRepository<Accessory,Long> {
}
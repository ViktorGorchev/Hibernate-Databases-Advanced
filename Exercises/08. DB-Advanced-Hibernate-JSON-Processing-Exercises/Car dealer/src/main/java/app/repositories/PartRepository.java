package app.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import app.domain.models.Part;

@Repository
public interface PartRepository extends JpaRepository<Part,Long> {
}
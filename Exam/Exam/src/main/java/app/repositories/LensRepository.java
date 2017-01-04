package app.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import app.domain.models.Lens;

@Repository
public interface LensRepository extends JpaRepository<Lens,Long> {
}
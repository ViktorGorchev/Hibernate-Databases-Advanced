package app.dao;

import app.domain.StoreLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface StoreLocationDao extends JpaRepository<StoreLocation, Long> {

}

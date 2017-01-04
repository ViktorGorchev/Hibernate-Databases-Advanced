package app.dao;

import app.domain.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface LicenseDao extends JpaRepository<License, Long> {

}

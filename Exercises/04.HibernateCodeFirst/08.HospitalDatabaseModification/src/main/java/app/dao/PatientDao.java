package app.dao;

import app.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PatientDao extends JpaRepository<Patient, Long> {
}

package app.dao;

import app.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DoctorDao extends JpaRepository<Doctor, Long>{
}

package app.serviceImpl;

import app.dao.DoctorDao;
import app.domain.Doctor;
import app.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorDao doctorDao;

    @Override
    public void persist(Doctor doctor) {
        this.doctorDao.saveAndFlush(doctor);
    }
}

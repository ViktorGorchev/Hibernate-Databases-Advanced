package app.serviceImpl;

import app.dao.PatientDao;
import app.domain.Patient;
import app.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientDao patientDao;

    @Override
    public void persist(Patient patient) {
        this.patientDao.saveAndFlush(patient);
    }
}
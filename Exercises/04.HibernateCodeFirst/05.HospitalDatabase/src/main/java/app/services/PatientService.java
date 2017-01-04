package app.services;

import app.domain.Patient;

public interface PatientService {
    void persist(Patient patient);
}

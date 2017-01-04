package app.serviceImpl;

import app.dao.MedicamentDao;
import app.domain.Medicament;
import app.services.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentServiceImpl implements MedicamentService{

    @Autowired
    private MedicamentDao medicamentDao;

    @Override
    public void persist(Medicament medicament) {
        this.medicamentDao.saveAndFlush(medicament);
    }
}
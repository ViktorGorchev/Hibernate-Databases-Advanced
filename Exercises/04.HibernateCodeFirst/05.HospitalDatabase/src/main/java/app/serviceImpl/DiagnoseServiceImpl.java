package app.serviceImpl;

import app.dao.DiagnoseDao;
import app.domain.Diagnose;
import app.services.DiagnoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnoseServiceImpl implements DiagnoseService {

    @Autowired
    private DiagnoseDao diagnoseDao;

    @Override
    public void persist(Diagnose diagnose) {
        this.diagnoseDao.saveAndFlush(diagnose);
    }
}
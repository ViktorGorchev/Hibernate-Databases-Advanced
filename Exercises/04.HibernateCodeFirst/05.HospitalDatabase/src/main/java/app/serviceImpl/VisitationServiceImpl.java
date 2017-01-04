package app.serviceImpl;

import app.dao.VisitationDao;
import app.domain.Visitation;
import app.services.VisitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitationServiceImpl implements VisitationService{

    @Autowired
    private VisitationDao visitationDao;

    @Override
    public void persist(Visitation visitation) {
        this.visitationDao.saveAndFlush(visitation);
    }
}

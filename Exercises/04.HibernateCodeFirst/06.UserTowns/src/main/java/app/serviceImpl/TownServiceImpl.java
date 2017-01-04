package app.serviceImpl;

import app.dao.TownDao;
import app.domain.Town;
import app.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TownServiceImpl implements TownService{

    @Autowired
    private TownDao townDao;

    @Override
    public void persist(Town town) {
        this.townDao.saveAndFlush(town);
    }
}

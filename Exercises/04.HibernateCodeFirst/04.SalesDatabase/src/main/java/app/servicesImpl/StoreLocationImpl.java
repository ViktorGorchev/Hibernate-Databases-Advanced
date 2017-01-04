package app.servicesImpl;

import app.dao.StoreLocationDao;
import app.domain.StoreLocation;
import app.services.StoreLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreLocationImpl  implements StoreLocationService{

    @Autowired
    private StoreLocationDao storeLocationDao;

    @Override
    public void persist(StoreLocation storeLocation) {
        this.storeLocationDao.saveAndFlush(storeLocation);
    }
}

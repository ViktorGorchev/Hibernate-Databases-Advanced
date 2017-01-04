package app.servicesImpl;

import app.dao.ResourceDao;
import app.domain.Resource;
import app.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourcesServiceImpl implements ResourceService{

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public void save(Resource resource) {
        this.resourceDao.save(resource);
    }

    @Override
    public Iterable<Resource> findAll() {
        return this.resourceDao.findAll();
    }
}

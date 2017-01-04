package app.services;

import app.domain.Resource;

public interface ResourceService {
    void save(Resource resource);

    Iterable<Resource> findAll();
}

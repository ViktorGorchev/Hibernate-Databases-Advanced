package app.serviceImpl;

import app.dao.TagDao;
import app.domain.Tag;
import app.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService{

    @Autowired
    private TagDao tagDao;

    @Override
    public void save(Tag tag) {
        this.tagDao.saveAndFlush(tag);
    }
}

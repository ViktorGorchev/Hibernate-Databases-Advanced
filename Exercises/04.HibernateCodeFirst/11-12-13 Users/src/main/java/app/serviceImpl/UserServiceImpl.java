package app.serviceImpl;


import app.dao.UserDao;
import app.domain.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void persist(User user) {
        this.userDao.saveAndFlush(user);
    }

    @Override
    public List<User> findUsersByEmailDomain(String domain) {
        return this.userDao.findByEmailLike("%" + domain);
    }

    @Override
    public Integer countGreaterProfilePictures(Integer size) {
        return this.userDao.countByProfilePictureGreaterThen(size);
    }

    @Override
    public List<User> usresNotLoggedInAfterDate(Date date) {
        return this.userDao.findByLastTimeLoggedInSmallerOrEqualThen(date);
    }

    @Override
    public void removeUser(User user) {
        this.userDao.delete(user);
    }


}

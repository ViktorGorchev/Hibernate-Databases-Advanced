package app.serviceImpl;


import app.dao.UserDao;
import app.domain.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void persist(User user) {
        this.userDao.saveAndFlush(user);
    }
}

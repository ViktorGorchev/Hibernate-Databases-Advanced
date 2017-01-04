package app.service;

import app.domain.User;

import java.util.Date;
import java.util.List;

public interface UserService {
    void persist(User user);

    List<User> findUsersByEmailDomain(String domain);

    Integer countGreaterProfilePictures(Integer size);

    List<User> usresNotLoggedInAfterDate(Date date);

    void removeUser(User user);
}

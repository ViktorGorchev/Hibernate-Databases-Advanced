package app.dao;


import app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface UserDao extends JpaRepository<User, Long>{

    List<User> findByEmailLike(String domain);

    @Query("SELECT COUNT(u) FROM User AS u WHERE LENGTH(u.profilePicture) > :size")
    Integer countByProfilePictureGreaterThen(@Param("size") Integer size);

    @Query("SELECT u FROM User AS u WHERE u.lastTimeLoggedIn <= :date")
    List<User> findByLastTimeLoggedInSmallerOrEqualThen(@Param("date") Date date);
}

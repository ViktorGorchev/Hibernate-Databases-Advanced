package app.repositories;

import app.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long>{

    @Query(value = "SELECT u FROM User AS u " +
            "INNER JOIN u.productsSold AS p " +
            "WHERE u.productsSold.size > 0 " +
            "AND p.buyer IS NOT NULL " +
            "ORDER BY u.lastName ASC, u.firstName ASC "
            )
    List<User> findWithMoreThanOneBuyer();

    @Query(value = "SELECT u FROM User AS u " +
            "WHERE u.productsSold.size > 0 " +
            "ORDER BY u.productsSold.size DESC, u.lastName ASC ")
    List<User> usersWithProductsSoldOrdered();
}

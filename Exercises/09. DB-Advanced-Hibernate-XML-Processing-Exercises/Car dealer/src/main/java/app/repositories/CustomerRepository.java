package app.repositories;

import app.domain.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query(value = "SELECT c FROM Customer AS c " +
            "ORDER BY c.birthDate ASC ")
    List<Customer> getAllCustomersOrdered();

    @Query(value = "SELECT c FROM Customer  AS c " +
        "WHERE c.sales.size > 0 ")
    List<Customer> findBuyers();


}
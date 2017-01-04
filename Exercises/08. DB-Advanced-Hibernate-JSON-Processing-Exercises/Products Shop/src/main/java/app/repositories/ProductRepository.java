package app.repositories;

import app.domain.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p " +
            "FROM Product AS p " +
            "WHERE p.buyer IS NULL " +
            "AND p.price BETWEEN :fromPrice AND :toPrice " +
            "ORDER BY p.price ASC ")
    List<Product> findProductsInPriceRange(
            @Param(value = "fromPrice") BigDecimal fromPrice,
            @Param(value = "toPrice") BigDecimal toPrice
    );

}

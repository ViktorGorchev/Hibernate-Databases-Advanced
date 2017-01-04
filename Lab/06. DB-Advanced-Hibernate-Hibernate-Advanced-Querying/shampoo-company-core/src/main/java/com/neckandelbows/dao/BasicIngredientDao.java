package com.neckandelbows.dao;

import com.neckandelbows.domain.ingredients.BasicIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BasicIngredientDao extends JpaRepository<BasicIngredient, Long>{

    List<BasicIngredient> findByPriceIsNullOrderByNameDescPriceDesc();

    List<BasicIngredient> findByNameStartsWith(String name);

    List<BasicIngredient> findByNameInOrderByPriceAsc(String... names);

    @Query(value = "SELECT i " +
                    "FROM BasicIngredient AS i " +
                    "WHERE i.name IN :names " +
                    "ORDER BY i.id DESC ")
    List<BasicIngredient> findByNameInOrderByIdDesc(@Param(value = "names") String... names);

    List<BasicIngredient> findByIngredientsSum(@Param(value = "sum_price")BigDecimal sumPrice);

    List<Object[]> findAllIngredientsAndShampooBrands();

    @Modifying
    Integer deleteByName(@Param(value = "name") String name);

    @Modifying
    Integer increasePrice();

    @Modifying
    @Query(value = "UPDATE BasicIngredient AS i " +
            "SET i.price = i.price * 1.5 " +
            "WHERE i.name IN :names")
    Integer increasePriceByNames(@Param(value = "names") String... names);
}

package com.neckandelbows.dao;

import com.neckandelbows.domain.enums.Size;
import com.neckandelbows.domain.ingredients.BasicIngredient;
import com.neckandelbows.domain.labels.ClassicLabel;
import com.neckandelbows.domain.labels.Label;
import com.neckandelbows.domain.shampoos.BasicShampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface BasicShampooDao extends JpaRepository<BasicShampoo, Long>{

    List<BasicShampoo> findByBrand(String brand);

    List<BasicShampoo> findByBrandAndSize(String brand, Size size);

    List<BasicShampoo> findBySizeOrLabelOrderByPriceAsc(Size size, ClassicLabel classicLabel);

    List<BasicShampoo> findByPriceGreaterThanOrderByBrandDesc(BigDecimal price);

    Long countByPriceIsLessThan(BigDecimal price);

    @Query(value = "SELECT b FROM BasicShampoo AS b WHERE b.label = :label")
    List<BasicShampoo> findByLabel(@Param(value = "label") Label label);

    @Query(value = "SELECT s " +
            "FROM BasicShampoo AS s " +
            "INNER JOIN s.ingredients AS i " +
            "WHERE i IN :ingredients")
    List<BasicShampoo> findByIngredientsIn(@Param(value = "ingredients") Set<BasicIngredient> ingredients);

    @Query(value = "SELECT s " +
            "FROM BasicShampoo AS s " +
            "RIGHT JOIN s.ingredients AS i " +
            "GROUP BY s.id " +
            "HAVING COUNT(i.id) < :ingredientsCount")
    List<BasicShampoo> findByIngredientsCount(@Param(value = "ingredientsCount") Long count);

    @Query(value = "SELECT s " +
            "FROM BasicShampoo AS s " +
            "RIGHT JOIN s.batch AS b " +
            "WHERE b.batchDate < :date")
    List<BasicShampoo> findByBatchDate(@Param(value = "date") Date date);

    @Query(value = "SELECT s " +
            "FROM BasicShampoo AS s " +
            "LEFT JOIN s.ingredients AS i " +
            "GROUP BY s.id " +
            "HAVING SUM(i.price) < :price")
    List<BasicShampoo> findByIngredientSum(@Param(value = "price") BigDecimal price);

    @Query(value = "SELECT s " +
            "FROM BasicShampoo AS s " +
            "INNER JOIN s.batch AS b " +
            "INNER JOIN s.label AS l " +
            "WHERE b.id = :bachId AND s.label.subtitle != :labelSubtitle")
    List<BasicShampoo> findByBatchAndLabel(
            @Param(value = "bachId") Long bachId, @Param(value = "labelSubtitle") String labelSubtitle);
}

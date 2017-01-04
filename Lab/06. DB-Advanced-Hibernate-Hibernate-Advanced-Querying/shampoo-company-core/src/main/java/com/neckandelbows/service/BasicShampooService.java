package com.neckandelbows.service;


import com.neckandelbows.domain.enums.Size;
import com.neckandelbows.domain.ingredients.BasicIngredient;
import com.neckandelbows.domain.labels.ClassicLabel;
import com.neckandelbows.domain.labels.Label;
import com.neckandelbows.domain.shampoos.BasicShampoo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface BasicShampooService {

    void create(BasicShampoo basicShampoo);

    List<BasicShampoo> findByBrand(String brand);

    List<BasicShampoo> findByBrandAndSize(String brand, Size size);

    List<BasicShampoo> findBySizeOrLabelOrderByPriceAsc(Size size, ClassicLabel classicLabel);

    List<BasicShampoo> findByPriceGreaterThanOrderByBrandDesc(BigDecimal price);

    Long countByPriceIsLessThan(BigDecimal price);

    List<BasicShampoo> findByLabel(Label label);

    List<BasicShampoo> findByIngredientsIn(Set<BasicIngredient> ingredients);

    List<BasicShampoo> findByIngredientsCount(Long count);

    List<BasicShampoo> findByBatchDate(Date date);

    List<BasicShampoo> findByIngredientSum(BigDecimal price);

    List<BasicShampoo> findByBatchAndLabel(Long bachId, String labelSubtitle);
}

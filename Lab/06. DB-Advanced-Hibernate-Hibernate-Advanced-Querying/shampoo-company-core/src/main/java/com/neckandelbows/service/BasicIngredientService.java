package com.neckandelbows.service;


import com.neckandelbows.domain.ingredients.BasicIngredient;

import java.math.BigDecimal;
import java.util.List;

public interface BasicIngredientService {

    void create(BasicIngredient basicIngredient);

    BasicIngredient retrieve(long id);

    List<BasicIngredient> findByPriceIsNullOrderByNameDescPriceDesc();

    List<BasicIngredient> findByNameStartsWith(String name);

    List<BasicIngredient> findByNameInOrderByPriceAsc(String... names);

    List<BasicIngredient> findByNameInOrderByIdDesc(String... names);

    List<BasicIngredient> findByIngredientsSum(BigDecimal sumPrice);

    List<Object[]> findAllIngredientsAndShampooBrands();

    Integer deleteByName(String name);

    Integer increasePrice();

    Integer increasePriceByNames(String... names);
}

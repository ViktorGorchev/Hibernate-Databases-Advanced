package com.neckandelbows.serviceImpl;

import com.neckandelbows.dao.BasicIngredientDao;
import com.neckandelbows.domain.ingredients.BasicIngredient;
import com.neckandelbows.service.BasicIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BasicIngredientServiceImpl implements BasicIngredientService {

    @Autowired
    private BasicIngredientDao basicIngredientDao;

    @Override
    public void create(BasicIngredient basicIngredient) {
        basicIngredientDao.saveAndFlush(basicIngredient);
    }

    @Override
    public BasicIngredient retrieve(long id) {
        return basicIngredientDao.findOne(id);
    }

    @Override
    public List<BasicIngredient> findByPriceIsNullOrderByNameDescPriceDesc() {
        return this.basicIngredientDao.findByPriceIsNullOrderByNameDescPriceDesc();
    }

    @Override
    public List<BasicIngredient> findByNameStartsWith(String name) {
        return this.basicIngredientDao.findByNameStartsWith(name);
    }

    @Override
    public List<BasicIngredient> findByNameInOrderByPriceAsc(String... names) {
        return this.basicIngredientDao.findByNameInOrderByPriceAsc(names);
    }

    @Override
    public List<BasicIngredient> findByNameInOrderByIdDesc(String... names) {
        return this.basicIngredientDao.findByNameInOrderByIdDesc(names);
    }

    @Override
    public List<BasicIngredient> findByIngredientsSum(BigDecimal sumPrice) {
        return this.basicIngredientDao.findByIngredientsSum(sumPrice);
    }

    @Override
    public List<Object[]> findAllIngredientsAndShampooBrands() {
        return this.basicIngredientDao.findAllIngredientsAndShampooBrands();
    }

    @Override
    public Integer deleteByName(String name) {
        return this.basicIngredientDao.deleteByName(name);
    }

    @Override
    public Integer increasePrice() {
        return this.basicIngredientDao.increasePrice();
    }

    @Override
    public Integer increasePriceByNames(String... names) {
        return this.basicIngredientDao.increasePriceByNames(names);
    }
}

package com.neckandelbows.serviceImpl;

import com.neckandelbows.dao.BasicShampooDao;
import com.neckandelbows.domain.enums.Size;
import com.neckandelbows.domain.ingredients.BasicIngredient;
import com.neckandelbows.domain.labels.ClassicLabel;
import com.neckandelbows.domain.labels.Label;
import com.neckandelbows.domain.shampoos.BasicShampoo;
import com.neckandelbows.service.BasicShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class BasicShampooServiceImpl implements BasicShampooService {

    @Autowired
    private BasicShampooDao basicShampooDao;

    @Override
    public void create(BasicShampoo basicShampoo) {
        basicShampooDao.saveAndFlush(basicShampoo);
    }

    @Override
    public List<BasicShampoo> findByBrand(String brand) {
        return this.basicShampooDao.findByBrand(brand);
    }

    @Override
    public List<BasicShampoo> findByBrandAndSize(String brand, Size size) {
        return this.basicShampooDao.findByBrandAndSize(brand, size);
    }

    @Override
    public List<BasicShampoo> findBySizeOrLabelOrderByPriceAsc(Size size, ClassicLabel classicLabel) {
        return this.basicShampooDao.findBySizeOrLabelOrderByPriceAsc(size, classicLabel);
    }

    @Override
    public List<BasicShampoo> findByPriceGreaterThanOrderByBrandDesc(BigDecimal price) {
        return this.basicShampooDao.findByPriceGreaterThanOrderByBrandDesc(price);
    }

    @Override
    public Long countByPriceIsLessThan(BigDecimal price) {
        return this.basicShampooDao.countByPriceIsLessThan(price);
    }

    @Override
    public List<BasicShampoo> findByLabel(Label label) {
        return this.basicShampooDao.findByLabel(label);
    }

    @Override
    public List<BasicShampoo> findByIngredientsIn(Set<BasicIngredient> ingredients) {
        return this.basicShampooDao.findByIngredientsIn(ingredients);
    }

    @Override
    public List<BasicShampoo> findByIngredientsCount(Long count) {
        return this.basicShampooDao.findByIngredientsCount(count);
    }

    @Override
    public List<BasicShampoo> findByBatchDate(Date date) {
        return this.basicShampooDao.findByBatchDate(date);
    }

    @Override
    public List<BasicShampoo> findByIngredientSum(BigDecimal price) {
        return this.basicShampooDao.findByIngredientSum(price);
    }

    @Override
    public List<BasicShampoo> findByBatchAndLabel(Long bachId, String labelSubtitle) {
        return this.basicShampooDao.findByBatchAndLabel(bachId, labelSubtitle);
    }
}

package com.neckandelbows.terminal;

import com.neckandelbows.domain.batches.ProductionBatch;
import com.neckandelbows.domain.enums.Size;
import com.neckandelbows.domain.ingredients.BasicIngredient;
import com.neckandelbows.domain.ingredients.Strawberry;
import com.neckandelbows.domain.labels.ClassicLabel;
import com.neckandelbows.domain.labels.Label;
import com.neckandelbows.domain.shampoos.BasicShampoo;
import com.neckandelbows.service.BasicIngredientService;
import com.neckandelbows.service.BasicShampooService;
import com.neckandelbows.service.ClassicLabelService;
import com.neckandelbows.service.ProductionBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Transactional
public class Terminal implements CommandLineRunner {

    @Autowired
    private BasicIngredientService basicIngredientService;

    @Autowired
    private BasicShampooService basicShampooService;

    @Autowired
    private ProductionBatchService productionBatchService;

    @Autowired
    private ClassicLabelService classicLabelService;

    @Override
    public void run(String... strings) throws Exception {

       //Query Methods

        //1.
        List<BasicShampoo> shampoos = this.basicShampooService.findByBrand("Fresh Nuke");
        for (BasicShampoo shampoo : shampoos) {
            System.out.println(shampoo.toString());
        }


        //2.
        List<BasicShampoo> shampoos2 = this.basicShampooService.findByBrandAndSize("Fresh Nuke", Size.LARGE);
        for (BasicShampoo shampoo : shampoos2) {
            System.out.println(shampoo.toString());
        }

        //3.
        ClassicLabel label = this.classicLabelService.findById(1L);
        List<BasicShampoo> shampoos3 = this.basicShampooService.findBySizeOrLabelOrderByPriceAsc(Size.LARGE, label);
        for (BasicShampoo shampoo : shampoos3) {
            System.out.println(shampoo.toString());
        }

        //4.
        List<BasicShampoo> shampoos4 =
                this.basicShampooService.findByPriceGreaterThanOrderByBrandDesc(new BigDecimal("5.0"));
        for (BasicShampoo shampoo : shampoos4) {
            System.out.println(shampoo.toString());
        }

        //5.
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse("21/12/2012");
        List<ProductionBatch> batches = this.productionBatchService.findByBatchDateAfter(date);
        for (ProductionBatch batch : batches) {
            System.out.println(batch.toString());
        }

        //6.
        List<BasicIngredient> basicIngredients = this.basicIngredientService.findByPriceIsNullOrderByNameDescPriceDesc();
        for (BasicIngredient basicIngredient : basicIngredients) {
            System.out.println(basicIngredient.toString());
        }

        //7.
        List<BasicIngredient> basicIngredients2 = this.basicIngredientService.findByNameStartsWith("m");
        for (BasicIngredient basicIngredient : basicIngredients2) {
            System.out.println(basicIngredient.toString());
        }

        //8.
        List<BasicIngredient> basicIngredients3 =
                this.basicIngredientService.findByNameInOrderByPriceAsc("mint", "nettle");
        for (BasicIngredient basicIngredient : basicIngredients3) {
            System.out.println(basicIngredient.toString());
        }

        //9.
        List<ProductionBatch> productionBatches =
                this.productionBatchService.findByShampoosIsNullOrderByBatchDateDesc();
        for (ProductionBatch productionBatch : productionBatches) {
            System.out.println(productionBatch.toString());
        }

        //10.
        Long shampoosCount = this.basicShampooService.countByPriceIsLessThan(new BigDecimal("10.0"));
        System.out.println(shampoosCount);


        //JPQL

        //11.
        Label label2 = this.classicLabelService.findById(1L);
        List<BasicShampoo> shampoos5 = this.basicShampooService.findByLabel(label2);
        for (BasicShampoo basicShampoo : shampoos5) {
            System.out.println(basicShampoo.toString());
        }

        //12.
        List<BasicIngredient> basicIngredients4 =
                this.basicIngredientService.findByNameInOrderByIdDesc("mint", "nettle");
        for (BasicIngredient basicIngredient : basicIngredients4) {
            System.out.println(basicIngredient.toString());
        }

        //13.
        List<BasicIngredient> basicIngredients5 =
                this.basicIngredientService.findByNameInOrderByIdDesc("mint", "nettle");
        Set<BasicIngredient> basicIngredientsSet = new HashSet<>(basicIngredients5);
        List<BasicShampoo> shampoos6 = this.basicShampooService.findByIngredientsIn(basicIngredientsSet);
        for (BasicShampoo basicShampoo : shampoos6) {
            System.out.println(basicShampoo.toString());
        }

        //14.
        List<BasicShampoo> shampoos7 = this.basicShampooService.findByIngredientsCount(5L);
        for (BasicShampoo basicShampoo : shampoos7) {
            System.out.println(basicShampoo.toString());
        }

        //15.
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        Date date2 = sdf2.parse("21/12/2017");
        List<BasicShampoo> shampoos8 = this.basicShampooService.findByBatchDate(date2);
        for (BasicShampoo basicShampoo : shampoos8) {
            System.out.println(basicShampoo);
        }

        //16.
        List<BasicShampoo> shampoos9 = this.basicShampooService.findByIngredientSum(new BigDecimal("1000"));
        for (BasicShampoo basicShampoo : shampoos9) {
            System.out.println(basicShampoo.toString());
        }

        //17.
        List<BasicShampoo> shampoos10 = this.basicShampooService.findByBatchAndLabel(1L, "ssssss");
        for (BasicShampoo basicShampoo : shampoos10) {
            System.out.println(basicShampoo);
        }

        //18.
        List<BasicIngredient> ingredients6 = this.basicIngredientService.findByIngredientsSum(new BigDecimal("30"));
        for (BasicIngredient basicIngredient : ingredients6) {
            System.out.println(basicIngredient.toString());
        }

        //19.
        List<Object[]> data = this.basicIngredientService.findAllIngredientsAndShampooBrands();
        for (Object[] objects : data) {
            String ingredientName = String.valueOf(objects[0]);
            String shampooBrand = String.valueOf(objects[1]);

            System.out.println(ingredientName + " -> " + shampooBrand);
        }

        //20.
        List<Object[]> data2 = this.productionBatchService.findBatchDateAndShampooLabelTitle();
        for (Object[] objects : data2) {
            Date bachDate = (Date) objects[0];
            String labelTitle = String.valueOf(objects[1]);

            System.out.println(bachDate.toString() + " -> " + labelTitle);
        }

        //21.
        BasicIngredient strawberry = new Strawberry();
        this.basicIngredientService.create(strawberry);

        Integer rowsAffected1 = this.basicIngredientService.deleteByName("Strawberry");
        System.out.println(rowsAffected1);

        //22.
        Integer rowsAffected2 = this.basicIngredientService.increasePrice();
        System.out.println(rowsAffected2);

        //23.
        Integer rowsAffected3 = this.basicIngredientService.increasePriceByNames("mint", "strawberry");
        System.out.println(rowsAffected3);
    }
}
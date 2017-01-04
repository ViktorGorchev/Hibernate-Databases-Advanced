package app.terminal;

import app.domain.dto.ingrediantDtos.BasicChemicalIngredientDto;
import app.domain.dto.ingrediantDtos.BasicIngredientDto;
import app.domain.dto.shampooDtos.BasicShampooDto;
import app.services.basicIngredient.BasicIngredientService;
import app.services.basicShampoo.BasicShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class Terminal implements CommandLineRunner{

    @Autowired
    private BasicIngredientService basicIngredientService;

    @Autowired
    private BasicShampooService basicShampooService;

    @Override
    public void run(String... strings) throws Exception {
        this.seedIngredients();
        this.seedShampoos();

        List<BasicIngredientDto> ingredientDtos = this.basicIngredientService.findAllMint();
        for (BasicIngredientDto ingredientDto : ingredientDtos) {
            System.out.println(ingredientDto.toString());
        }

        List<BasicChemicalIngredientDto> basicChemicalIngredientDtos =
                this.basicIngredientService.findAllIngredientsInFreshNuke();
        for (BasicChemicalIngredientDto basicChemicalIngredientDto : basicChemicalIngredientDtos) {
            System.out.println(basicChemicalIngredientDto);
        }

    }

    private void seedIngredients(){
        this.basicIngredientService.createMint();
        this.basicIngredientService.createNettle();
        this.basicIngredientService.createAmmoniumChloride();

        BasicIngredientDto basicIngredientDto = new BasicIngredientDto();
        basicIngredientDto.setName("Custom mint product");
        basicIngredientDto.setPrice(new BigDecimal("33"));
        this.basicIngredientService.createCustomMint(basicIngredientDto);
    }

    private void seedShampoos(){
        this.basicShampooService.createPinkPanther();
        this.basicShampooService.createFreshNuke();

        BasicShampooDto basicShampooDto = new BasicShampooDto();
        basicShampooDto.setBrand("Custom Fresh Nuke");
        basicShampooDto.setPrice(new BigDecimal("77"));

        this.basicShampooService.createCustomFreshNuke(basicShampooDto);
    }
}

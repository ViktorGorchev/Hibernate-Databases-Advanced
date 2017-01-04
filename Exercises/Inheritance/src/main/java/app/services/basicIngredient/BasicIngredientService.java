package app.services.basicIngredient;

import app.domain.dto.ingrediantDtos.BasicChemicalIngredientDto;
import app.domain.dto.ingrediantDtos.BasicIngredientDto;

import java.util.List;

public interface BasicIngredientService {

    void createMint();

    void createNettle();

    void createAmmoniumChloride();

    void createCustomMint(BasicIngredientDto basicIngredientDto);

    List<BasicIngredientDto> findAllMint();

    List<BasicChemicalIngredientDto> findAllIngredientsInFreshNuke();
}
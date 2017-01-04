package app.services.basicIngredient;

import app.domain.dto.ingrediantDtos.BasicChemicalIngredientDto;
import app.domain.dto.ingrediantDtos.BasicIngredientDto;
import app.domain.ingredients.AmmoniumChloride;
import app.domain.ingredients.BasicIngredient;
import app.domain.ingredients.Mint;
import app.domain.ingredients.Nettle;
import app.parsers.modelParser.ModelParser;
import app.repositories.BasicIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BasicIngredientServiceImpl implements BasicIngredientService {

	@Autowired
	private BasicIngredientRepository basicIngredientRepository;

    @Autowired
    private ModelParser modelParser;


    @Override
    public void createMint() {
        BasicIngredient mint = new Mint();
        this.basicIngredientRepository.saveAndFlush(mint);
    }

    @Override
    public void createNettle() {
        BasicIngredient nettle = new Nettle();
        this.basicIngredientRepository.saveAndFlush(nettle);
    }

    @Override
    public void createAmmoniumChloride() {
        BasicIngredient ammoniumChloride = new AmmoniumChloride();
        this.basicIngredientRepository.saveAndFlush(ammoniumChloride);
    }

    @Override
    public void createCustomMint(BasicIngredientDto basicIngredientDto) {
        BasicIngredient mint = new Mint();
        mint.setName(basicIngredientDto.getName());
        mint.setPrice(basicIngredientDto.getPrice());

        this.basicIngredientRepository.saveAndFlush(mint);
    }

    @Override
    public List<BasicIngredientDto> findAllMint() {
        List<BasicIngredient> ingredients = this.basicIngredientRepository.findAllMint();
        List<BasicIngredientDto> ingredientDtos = this.modelParser.convert(ingredients, BasicIngredientDto.class);

        return ingredientDtos;
    }

    @Override
    public List<BasicChemicalIngredientDto> findAllIngredientsInFreshNuke() {
        List<BasicIngredient> basicIngredients = this.basicIngredientRepository.findAllIngredientsInFreshNuke();
        List<BasicChemicalIngredientDto> basicChemicalIngredientDtos =
                this.modelParser.convert(basicIngredients, BasicChemicalIngredientDto.class);

        return basicChemicalIngredientDtos;
    }
}
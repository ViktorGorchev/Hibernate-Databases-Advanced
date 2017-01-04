package app.services.basicShampoo;

import app.domain.dto.shampooDtos.BasicShampooDto;
import app.domain.ingredients.BasicIngredient;
import app.domain.shampoos.BasicShampoo;
import app.domain.shampoos.FreshNuke;
import app.domain.shampoos.PinkPanther;
import app.parsers.modelParser.ModelParser;
import app.repositories.BasicIngredientRepository;
import app.repositories.BasicShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class BasicShampooServiceImpl implements BasicShampooService {

	@Autowired
	private BasicShampooRepository basicShampooRepository;

    @Autowired
    private BasicIngredientRepository basicIngredientRepository;

    @Autowired
    private ModelParser modelParser;

    @Override
    public void createPinkPanther() {
        BasicShampoo pinkPanther = new PinkPanther();
        pinkPanther.setIngredients(this.seedIngredients());

        this.basicShampooRepository.saveAndFlush(pinkPanther);
    }

    @Override
    public void createFreshNuke() {
        BasicShampoo freshNuke = new FreshNuke();
        freshNuke.setIngredients(this.seedIngredients());

        this.basicShampooRepository.saveAndFlush(freshNuke);
    }

    @Override
    public void createCustomFreshNuke(BasicShampooDto basicShampooDto) {
        BasicShampoo customFreshNuke = new FreshNuke();
        customFreshNuke.setBrand(basicShampooDto.getBrand());
        customFreshNuke.setPrice(basicShampooDto.getPrice());
        customFreshNuke.setIngredients(this.seedIngredients());

        this.basicShampooRepository.saveAndFlush(customFreshNuke);
    }

    private Set<BasicIngredient> seedIngredients() {
        Set<BasicIngredient> ingredients = new HashSet<>(this.basicIngredientRepository.findAll());

        return ingredients;
    }
}